package com.sw.basis.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author DongLinmo
 * @create 2022/7/29
 */
@ApiModel(value = "借调记录增加或修改")
@Data
public class SecondmentIncreasedOrModifyDTO {

    @ApiModelProperty(value = "借调记录id")
    private Integer id;

    @ApiModelProperty(value = "申请部门")
    private String deptName;

    @ApiModelProperty(value = "申请部门编码")
    private String deptCode;

    @ApiModelProperty(value = "申请日期")
    private String updateTime;

    @ApiModelProperty(value = "创建人名称/申请人")
    private String createBy;

    @ApiModelProperty(value = "创建人编号/申请人编号")
    private String createCode;

    @ApiModelProperty(value = "项目名称")
    private String projectName;

    @ApiModelProperty(value = "项目编号")
    private String projectCode;

    @ApiModelProperty(value = "所属板块名称")
    private String sendPlageName;

    @ApiModelProperty(value = "所属板块编码")
    private String sendPlageCode;

    @ApiModelProperty(value = "负责部门")
    private String sendDeptName;

    @ApiModelProperty(value = "负责部门编码")
    private String sendDeptCode;

    @ApiModelProperty(value = "执业地点")
    private String address;

    @ApiModelProperty(value = "被借调人板块名称")
    private String plageName;

    @ApiModelProperty(value = "被借调人板块编码")
    private String plageCode;

    @ApiModelProperty(value = "借调协调人")
    private String coordinator;

    @ApiModelProperty(value = "结算方式")
    private String settlement;

    @ApiModelProperty(value = "其它要求")
    private String otherRequirements;


}
