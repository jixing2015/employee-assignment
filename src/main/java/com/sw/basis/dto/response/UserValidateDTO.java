package com.sw.basis.dto.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用户表校验DTO
 *
 * @author jixing2000
 * @since 2022-07-07
 */
@ApiModel(value = "用户表校验DTO")
@Data
public class UserValidateDTO {

    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "用户编号")
    private String code;

    @ApiModelProperty(value = "用户名称")
    private String name;

    @ApiModelProperty(value = "板块编号")
    private String plageCode;

    @ApiModelProperty(value = "板块名称")
    private String plageName;

    @ApiModelProperty(value = "区域编号")
    private String areaCode;

    @ApiModelProperty(value = "区域名称")
    private String areaName;

    @ApiModelProperty(value = "部门编号")
    private String deptCode;

    @ApiModelProperty(value = "部门名称")
    private String deptName;

    @ApiModelProperty(value = "条线编号")
    private String lineCode;

    @ApiModelProperty(value = "条线名称")
    private String lineName;

    @ApiModelProperty(value = "职级编号")
    private String levelCode;

    @ApiModelProperty(value = "职级名称")
    private String levelName;

    @ApiModelProperty(value = "执业资格")
    private String register;

    @ApiModelProperty(value = "专业编号")
    private String expertType;

    @ApiModelProperty(value = "状态;0，在职；1离职")
    private Integer state;

    @ApiModelProperty(value = "派工成本")
    private Integer dispatchCost;

}
