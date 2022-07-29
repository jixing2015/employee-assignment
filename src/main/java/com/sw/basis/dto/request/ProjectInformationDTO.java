package com.sw.basis.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author DongLinmo
 * @create 2022/7/25
 */
@ApiModel(value = "项目信息")
@Data
public class ProjectInformationDTO {

    @ApiModelProperty(value = "项目编号")
    private String projectCode;

    @ApiModelProperty(value = "项目名称")
    private String projectName;

    @ApiModelProperty(value = "部门编号")
    private String deptCode;

    @ApiModelProperty(value = "业务类型")
    private String businessType;

    @ApiModelProperty(value = "委托人")
    private String client;

    @ApiModelProperty(value = "被审计单位")
    private String auditee;

    @ApiModelProperty(value = "立项日期")
    private Data approvalDate;

    @ApiModelProperty(value = "风险分类")
    private String riskCategory;

    @ApiModelProperty(value = "负责经理编号")
    private String managerCode;

    @ApiModelProperty(value = "负责合伙人编号")
    private String partnerCode;


}
