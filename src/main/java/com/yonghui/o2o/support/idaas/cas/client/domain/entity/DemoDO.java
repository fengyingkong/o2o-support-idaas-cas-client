package com.yonghui.o2o.support.idaas.cas.client.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 测试模型
 *
 * @author zhanghai
 * @email 80730305@yonghui.cn
 * @date 2018-09-05 17:30:43
 */
@TableName("demo")
@Data
public class DemoDO extends BaseDO {

	/**
	 * uuid
	 */
	@TableId(type = IdType.UUID)
	private String id;

	/**
	 * 用户名
	 */
	private String userName;

}

