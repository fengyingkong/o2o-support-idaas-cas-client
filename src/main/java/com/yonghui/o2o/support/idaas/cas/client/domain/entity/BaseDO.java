package com.yonghui.o2o.support.idaas.cas.client.domain.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.util.Date;

/**
 * 基础信息表
 *
 * @author zhanghai
 * @email 80730305@yonghui.cn
 * @date 2018-09-05 17:30:43
 */
@Data
public class BaseDO extends Model{

	/**
	 * 是否删除 1:正常，0:已删除
	 */
	private Integer isDelete;

	/**
	 * 创建人
	 */
	private String createdBy;

	/**
	 * 创建时间
	 */
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date createdTime;

	/**
	 * 修改人
	 */
	private String updatedBy;

	/**
	 * 修改时间
	 */
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date updatedTime;

}

