package com.sw.basis.dto.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;


/**
 * 项目信息DTO
 *
 * @author jixing2000
 * @since 2022-07-29
 */
@ApiModel(value = "项目信息DTO")
@Data
public class ProjectDTO {

    @ApiModelProperty(value = "板块编号")
    private Integer pmprojectBusinesstype;

    @ApiModelProperty(value = "负责部门编号")
    private String pmprojectEntity;

    @ApiModelProperty(value = "项目类型")
    private Integer pmprojectPrjtmpid;

    @ApiModelProperty(value = "项目编号")
    private String pmprojectCode;

    @ApiModelProperty(value = "项目名称")
    private String pmprojectName;

    @ApiModelProperty(value = "委托人名称（字段名称）")
    private String pmprojectCustomer;

    @ApiModelProperty(value = "被审计单位名称（字段名称）")
    private String pmprojectExaminate;

    @ApiModelProperty(value = "项目立项日期")
    private Date approvalDate;

    @ApiModelProperty(value = "业务类型")
    private String pmprojectServicetype;

    @ApiModelProperty(value = "预计时间成本（万元）")
    private BigDecimal pmbusutakeTimecost;

    @ApiModelProperty(value = "项目状态")
    private Integer pmprojectStatus;

    @ApiModelProperty(value = "负责经理")
    private String pmprojectManager;

    @ApiModelProperty(value = "负责经理2")
    private String pmprojectManager2;

    @ApiModelProperty(value = "负责经理2状态")
    private String pmprojectManager2status;

    @ApiModelProperty(value = "现场负责人")
    private String pmprojectCedperson;

    @ApiModelProperty(value = "负责合伙人")
    private String pmprojectPartner;
}