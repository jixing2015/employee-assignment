package com.sw.basis.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * <p>
 * 项目表 ModifyDTO
 * </p>
 *
 * @author jixing2000
 * @since 2022-07-07
 */
@ApiModel(value = "项目表 ModifyDTO")
@Data
public class ProjectModifyDTO {

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

    @ApiModelProperty(value = "创建人")
    private String createBy;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新人")
    private String updateBy;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "是否删除;0表示未删除，1表示删除")
    private Integer delFlag;

}
