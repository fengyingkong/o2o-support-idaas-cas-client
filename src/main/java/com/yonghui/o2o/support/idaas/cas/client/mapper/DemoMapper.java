package com.yonghui.o2o.support.idaas.cas.client.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yonghui.o2o.support.idaas.cas.client.domain.entity.DemoDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * MP 支持不需要 UserMapper.xml 这个模块演示内置 CRUD
 *
 * @author zhanghai
 * @email 80730305@yonghui.cn
 * @date 2018-12-17 22:15:03
 */
@Mapper
public interface DemoMapper extends BaseMapper<DemoDO> {

	List<DemoDO> queryDemo();

}

