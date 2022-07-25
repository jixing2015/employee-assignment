package com.sw.basis.dto.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * <p>
 * 项目表校验DTO
 * </p>
 *
 * @author jixing2000
 * @since 2022-07-07
 */
@ApiModel(value = "项目表校验DTO")
@Data
public class ProjectValidateDTO {

    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "项目编号")
    private String projectCode;

    @ApiModelProperty(value = "主键")
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
    private Date approvalDate;

    @ApiModelProperty(value = "风险分类")
    private String riskCategory;

    @ApiModelProperty(value = "负责经理编号")
    private String managerCode;

    @ApiModelProperty(value = "负责合伙人编号")
    private String partnerCode;

    @ApiModelProperty(value = "预计时间成本")
    private Integer estimatedTimeCost;

}
