package com.sw.basis.dto.request;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author DongLinmo
 * @create 2022/7/25
 */
@Api(value = "信天游用户信息")
@Data
public class UserInformationDTO {

    @ApiModelProperty(value = "用户编号")
    private String code;

    @ApiModelProperty(value = "用户名称")
    private String name;

    @ApiModelProperty(value = "部门编号")
    private String deptCode;

    @ApiModelProperty(value = "职级编号")
    private String levelCode;

    @ApiModelProperty(value = "职级名称")
    private String levelName;

    @ApiModelProperty(value = "执业资格")
    private String register;

    @ApiModelProperty(value = "专业编号")
    private String expertType;


}
