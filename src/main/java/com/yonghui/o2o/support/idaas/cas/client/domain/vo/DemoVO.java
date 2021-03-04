package com.yonghui.o2o.support.idaas.cas.client.domain.vo;

import com.yonghui.web.domain.vo.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 测试模型
 *
 * @author zhanghai
 * @email 80730305@yonghui.cn
 * @date 2018-09-05 17:30:43
 */
@Data
@ApiModel
public class DemoVO extends BaseVO {

	@ApiModelProperty(value = "编码ID")
	private String id;

	@ApiModelProperty(value = "用户名")
	private String userName;

}

