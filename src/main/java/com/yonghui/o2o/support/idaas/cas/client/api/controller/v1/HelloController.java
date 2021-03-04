package com.yonghui.o2o.support.idaas.cas.client.api.controller.v1;

import com.alibaba.fastjson.JSONArray;
import com.yonghui.core.utils.R;
import com.yonghui.o2o.support.idaas.cas.client.config.Contants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.jasig.cas.client.authentication.AttributePrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;


/**
 * 测试API
 *
 * @author zhanghai 80730305@yonghui.cn
 */
@Slf4j
@Api(value = "测试API")
@RestController
@CrossOrigin
@RequestMapping(value = "/v1")
public class HelloController {

	@Value("${redirect.url}")
	private String redirectUrl;
	@Autowired
	private RedisTemplate redisTemplate;

	@GetMapping("/hello")
	@ApiOperation(value = "R«DemoVO»", notes = "DemoVO类型")
	public R<String> hello(HttpServletRequest request) throws UnknownHostException {
		log.info("--------------------hello-------------------"+JSONArray.toJSONString(request.getCookies()));

		return R.success("hello world，当前返回的后端IP地址为："+InetAddress.getLocalHost().getHostAddress());
	}

    @GetMapping("/login")
    @ApiOperation(value = "R«DemoVO»", notes = "DemoVO类型")
	public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        AttributePrincipal principal = (AttributePrincipal) request.getUserPrincipal();
        if (ObjectUtils.isEmpty(principal) || ObjectUtils.isEmpty(principal.getAttributes()) || StringUtils.isEmpty(principal.getName())) {

			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        	response.sendRedirect(redirectUrl);
        }

		HttpSession session = request.getSession();

		session.setAttribute("loginUserId", principal.getName());
		redisTemplate.opsForValue().set(Contants.REDIS_SESSION_CAS_CLIENT.concat(principal.getName()), session.getId());
		log.info("成功登录，并存储用户信息：{}", Contants.REDIS_SESSION_CAS_CLIENT.concat(request.getRequestedSessionId()));
        response.sendRedirect(redirectUrl);
    }


    @GetMapping("/user")
    @ApiOperation(value = "R«DemoVO»", notes = "DemoVO类型")
    public ResponseEntity<R> user(HttpServletRequest request) {

		Map map = new HashMap();
		map.put("username", "test");
		map.put("employee", "9999999");
		return new ResponseEntity<>(R.success(map), HttpStatus.OK);

    }

	/**
	 * 退出
	 * @param request
	 * @return
	 */
	@RequestMapping("/logout")
	public ResponseEntity<R> logout(HttpServletRequest request, HttpServletResponse response) throws IOException {

		HttpSession session = request.getSession();

		if (ObjectUtils.isEmpty(session.getAttribute("loginUserId"))) {
			response.sendRedirect(redirectUrl);
		}
		Boolean delKey = redisTemplate.delete(Contants.REDIS_SESSION_CAS_CLIENT.concat((String)session.getAttribute("loginUserId")));
		log.info(delKey+"-----------退出系统并删除redis：{}", Contants.REDIS_SESSION_CAS_CLIENT.concat((String)session.getAttribute("loginUserId")));
		return new ResponseEntity<>(R.success("删除成功"), HttpStatus.OK);

	}



}


