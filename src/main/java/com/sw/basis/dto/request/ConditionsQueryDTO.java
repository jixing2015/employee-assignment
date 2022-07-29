package com.sw.basis.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author DongLinmo
 * @create 2022/7/29
 */
@ApiModel(value = "借调记录的查询条件")
@Data
public class ConditionsQueryDTO {

    @ApiModelProperty(value = "申请部门的名称")
    private String deptName;

    @ApiModelProperty(value = "创建人名称/申请人")
    private String createBy;

    @ApiModelProperty(value = "项目名称")
    private String projectName;

    @ApiModelProperty(value = "所属模块名称")
    private String plageName;

    @ApiModelProperty(value = "负责部门名称")
    private String sendDeptName;

    @ApiModelProperty(value = "被借调人板块名称")
    private String sendPlageName;

    @ApiModelProperty(value = "申请日期")
    private String updateTime;

}
