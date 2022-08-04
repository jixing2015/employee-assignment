package com.sw.basis.dto.query;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 部门字典查询
 * @author jixing2000
 **/
@Data
public class DeptQuery {

	@ApiModelProperty(value = "编号(板块编号、区域编号、条线编号)")
	private String code;

	@ApiModelProperty(value = "类型：0，全部部门；1，板块编号；2，区域编号；3，条线编号")
	private Integer type;

}
