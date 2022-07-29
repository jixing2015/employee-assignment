package com.sw.basis.dto.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 借调记录信息DTO
 * </p>
 *
 *
 * @author DongLinmo
 * @create 2022/7/26
 */
@ApiModel(value = "借调记录信息DTO")
@Data
public class SecondmentRecordDTO {

    @ApiModelProperty(value = "借调记录id")
    private Integer id;

    @ApiModelProperty(value = "创建时间/借调申请日期")
    private Data createTime;

    @ApiModelProperty(value = "用户名称/借调申请人")
    private String name;

    @ApiModelProperty(value = "用户编号/借调申请人编号")
    private String code;

    @ApiModelProperty(value = "职级名称")
    private String levelName;

    @ApiModelProperty(value = "职级编号")
    private String levelCode;

    @ApiModelProperty(value = "部门名称")
    private String deptName;

    @ApiModelProperty(value = "部门编号")
    private String deptCode;

    @ApiModelProperty(value = "借调项目名称")
    private String projectName;

    @ApiModelProperty(value = "借调项目编号")
    private String projectCode;

    @ApiModelProperty(value = "借调协调人")
    private String coordinator;

    @ApiModelProperty(value = "被借调人姓名")
    private String eName;

    @ApiModelProperty(value = "被借调人编号")
    private String eCode;

    @ApiModelProperty(value = "被借调人部门名称")
    private String eDeptName;

    @ApiModelProperty(value = "被借调人部门编号")
    private String eDeptCode;

    @ApiModelProperty(value = "被借调人职级名称")
    private String eLevelName;

    @ApiModelProperty(value = "被借调人职级编号")
    private String eLevelCode;

    @ApiModelProperty(value = "派遣开始时间")
    private Data startTime;

    @ApiModelProperty(value = "派遣结束日期")
    private Data endTime;

    @ApiModelProperty(value = "派遣天数")
    private Integer days;

    @ApiModelProperty(value = "派遣小时数")
    private Integer hours;

    @ApiModelProperty(value = "结算方式")
    private String settlement;

    @ApiModelProperty(value = "每天派遣小时数")
    private Integer hoursPerDay;



}
