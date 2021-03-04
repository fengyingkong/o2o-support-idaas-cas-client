package com.yonghui.o2o.support.idaas.cas.client.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yonghui.o2o.support.idaas.cas.client.domain.entity.DemoDO;
import com.yonghui.o2o.support.idaas.cas.client.mapper.DemoMapper;
import com.yonghui.o2o.support.idaas.cas.client.server.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * SQL 定义
 *
 * @author zhanghai
 * @email 80730305@yonghui.cn
 * @date 2018-12-17 22:15:03
 */
@Slf4j
@Service
public class DemoServiceImpl extends ServiceImpl<DemoMapper, DemoDO> implements DemoService {
	@Resource
	DemoMapper demoMapper;

	@Override
	public List<DemoDO> queryDemo() {
		return demoMapper.queryDemo();
	}
}

