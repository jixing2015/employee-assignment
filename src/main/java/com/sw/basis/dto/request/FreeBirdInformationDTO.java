package com.sw.basis.dto.request;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author DongLinmo
 * @create 2022/7/25
 */
@Data
@Api(value = "信天游信息")
public class FreeBirdInformationDTO{

    @ApiModelProperty(value = "姓名")
    private String hrempName;

    @ApiModelProperty(value = "工号")
    private String hrempCode;

    @ApiModelProperty(value = "部门")
    private String hrempOrg;

    @ApiModelProperty(value = "职级ID")
    private String hrempJobid;

    @ApiModelProperty(value = "职级名称")
    private String hrjobJobname;

    @ApiModelProperty(value = "职级名称")
    private String asorgOrgid;

    @ApiModelProperty(value = "部门名称")
    private String asorgOrgname;

    @ApiModelProperty(value = "项目代码")
    private String pmprojectCode;

    @ApiModelProperty(value = "项目名称")
    private String pmprojectName;

    @ApiModelProperty(value = "项目种类/业务类型")
    private String  pmprojectServicetype;

    @ApiModelProperty(value = "客户名称/委托人名称")
    private String pmprojectCustomer;

    @ApiModelProperty(value = "被审计单位名称")
    private String pmprojectExaminate;

    @ApiModelProperty(value = "立项日期")
    private Data pmprojectEstdate;

    @ApiModelProperty(value = "风险分类")
    private String pmprojectPmriskcate;

    @ApiModelProperty(value = "负责经理")
    private String pmprojectManager;

    @ApiModelProperty(value = "项目负责合伙人")
    private String pmprojectPartner;

    @ApiModelProperty(value = "板块")
    private String pmprojectBusinesstype;

    @ApiModelProperty(value = "预计收费")
    private String pmbusutakeExp;

    @ApiModelProperty(value = "预计时间成本")
    private String pmbusutakeTimecost;

    @ApiModelProperty(value = "预计差旅费")
    private String pmbusutakeTravelfee;

    @ApiModelProperty(value = "负责经理2")
    private String pmprojectManager2;

    @ApiModelProperty(value = "派遣开始时间")
    private Data  pmprjresFromdate;

    @ApiModelProperty(value = "派遣结束时间")
    private Data pmprjresTodate;

    @ApiModelProperty(value = "天数")
    private Integer pmprjresDays;

    @ApiModelProperty(value = "派工小时数")
    private Integer pmprjresHours;

    @ApiModelProperty(value = "派工成本")
    private String pmprjresAmt;

    @ApiModelProperty(value = "实际小时数")
    private Integer pmprjresWorkhours;

    @ApiModelProperty(value = "实际成本")
    private String pmprjresWorkamt;

    @ApiModelProperty(value = "是否借调\t0：否，1：是")
    private Integer pmprjresIsdispatch;

    @ApiModelProperty(value = "结算方式\t'0','工时'，'1','分成'，'2','人才基地'，'3','共享中心'")
    private Integer pmprjresBalancetype;

    @ApiModelProperty(value = "项目名称")
    private String pmlendreqPrjname;

    @ApiModelProperty(value = "项目执行地")
    private String pmlendreqPlace;

    @ApiModelProperty(value = "负责部门")
    private String pmlendreqPrjentity;

    @ApiModelProperty(value = "所属板块")
    private String pmlendreqPrjbusinesstype;

    @ApiModelProperty(value = "申请部门")
    private Data pmlendreqEntity;

    @ApiModelProperty(value = "申请日期")
    private Data pmlendreqDocdate;

    @ApiModelProperty(value = "申请人")
    private String pmlendreqReqemp;

    private String pmlendreqUuid;

    private String  pmlendreqCreateby;

    private String pmlendreqCreatedt;

    @ApiModelProperty(value = "状态\t0：未提交:1：待审批2：已批准3：已拒绝4：已处理")
    private Integer pmlendreqSstatus;

    @ApiModelProperty(value = "职级费率")
    private String pmcatehPayrate;

}
