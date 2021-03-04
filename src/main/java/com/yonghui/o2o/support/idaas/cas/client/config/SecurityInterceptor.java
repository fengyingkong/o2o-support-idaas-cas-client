package com.yonghui.o2o.support.idaas.cas.client.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author chensong
 * Date on  2021/3/1
 */
@Slf4j
public class SecurityInterceptor implements HandlerInterceptor {

    @Value("${redirect.url}")
    private String redirectUrl;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        log.info("请求路径是：{}", request.getRequestURI());
        HttpSession session = request.getSession();
        log.info("请求sessionId：{}", session.getId());
        if (ObjectUtils.isNotEmpty(session.getAttribute("loginUserId"))) {
            Object loginUserId = redisTemplate.opsForValue().get(Contants.REDIS_SESSION_CAS_CLIENT.concat((String) session.getAttribute("loginUserId")));
            log.info("-----------loginUserId：{}",loginUserId);
            log.info("-----------sessionId：{}", session.getId());
            if (!ObjectUtils.isEmpty(loginUserId) && loginUserId.toString().equals(session.getId())){
                return true;
            }
        }
        //401返回给前端，前端重定向登录地址
        response401(response);
        return false;
    }


    private void response401(HttpServletResponse response)
    {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");

        try
        {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().print("未登录，请重新登录：http://o2o-support-dev.o2o-support-idaas-vue-demo.devgw.yonghui.cn");
            log.info("未登录，返回401");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
