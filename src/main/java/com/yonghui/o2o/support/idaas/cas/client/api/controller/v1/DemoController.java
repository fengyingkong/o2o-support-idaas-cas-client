package com.yonghui.o2o.support.idaas.cas.client.api.controller.v1;

import com.yonghui.o2o.support.idaas.cas.client.domain.entity.DemoDO;
import com.yonghui.o2o.support.idaas.cas.client.server.service.DemoService;
import com.yonghui.core.utils.R;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 测试API
 *
 * @author zhanghai 80730305@yonghui.cn
 */
@RestController
@RequestMapping(value = "/v1")
@Slf4j
public class DemoController {

	@Resource
	private DemoService demoService;

	@GetMapping("/mysql")
	@ApiOperation(value = "MybatisPlus测试")
	public R<List<DemoDO>> mysql(@RequestParam String userName) {
		DemoDO demoDO = new DemoDO();
		demoDO.setUserName(userName);
		try {
			demoService.save(demoDO);
		} catch (Exception e) {
			log.error("创建用户失败", e);
			return R.error("创建用户失败");
		}
		return R.success(demoService.queryDemo());
	}

	@GetMapping("/test")
	public R test() {
		return R.success();
	}

}

