package com.sw.basis.dto.query;

import com.sw.basis.utils.vo.Pageable;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用户查询
 * @author jixing2000
 **/
@Data
public class SysUserQuery extends Pageable {

	@ApiModelProperty(value = "用户编号")
	private String code;

	@ApiModelProperty(value = "用户名称")
	private String name;

	@ApiModelProperty(value = "状态;0，在职；1离职")
	private Integer state;

}
