package com.sw.basis.dto.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author DongLinmo
 * @create 2022/7/29
 */
@ApiModel(value = "借调记录查询结果")
@Data
public class QueryResultsDTO {

    @ApiModelProperty(value = "项目名称")
    private String projectName;

    @ApiModelProperty(value = "执业地点")
    private String address;

    @ApiModelProperty(value = "负责部门")
    private String sendDeptCode;

    @ApiModelProperty(value = "负责部门名称")
    private String sendDeptName;

    @ApiModelProperty(value = "所属板块名称")
    private String plageName;

    @ApiModelProperty(value = "所属板块编号")
    private String plageCode;

    @ApiModelProperty(value = "状态")
    private String reviewStatus;

    @ApiModelProperty(value = "申请部门id")
    private String deptCode;

    @ApiModelProperty(value = "申请部门名称")
    private String deptName;

    @ApiModelProperty(value = "申请日期")
    private Data updateTime;

    @ApiModelProperty(value = "创建人名称/申请人")
    private String createBy;

    @ApiModelProperty(value = "创建人/申请人id")
    private String creatorCode;


}
