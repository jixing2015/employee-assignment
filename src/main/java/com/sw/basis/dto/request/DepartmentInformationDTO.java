package com.sw.basis.dto.request;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author DongLinmo
 * @create 2022/7/25
 */
@Data
@Api(value = "部门信息")
public class DepartmentInformationDTO {

    @ApiModelProperty(value = "部门编号")
    private String dept_code;

    @ApiModelProperty(value = "部门名称")
    private String dept_name;

    @ApiModelProperty(value = "父级部门编号")
    private String parent_code;

    @ApiModelProperty(value = "业务条线")
    private String line;

}
