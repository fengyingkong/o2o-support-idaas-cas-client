package com.yonghui.o2o.support.idaas.cas.client.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yonghui.o2o.support.idaas.cas.client.domain.entity.DemoDO;

import java.util.List;

/**
 * SQL 定义
 *
 * @author zhanghai
 * @email 80730305@yonghui.cn
 * @date 2018-12-17 22:15:03
 */
public interface DemoService extends IService<DemoDO> {

	List<DemoDO> queryDemo();

}


