package com.sw.basis.dto.request;

import com.sw.basis.entity.SecondmentDemandEntity;
import com.sw.basis.entity.SecondmentPeoplesEntity;
import com.sw.basis.entity.SysLogEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * @author DongLinmo
 * @create 2022/7/11
 */

@ApiModel(value = "借调申请入参")
@Data
public class SecondmentApplyDTO {

    @ApiModelProperty(name = "申请部门编号", notes = "不能为空")
    @NotBlank
    private String applyDeptCode;

    @ApiModelProperty(name = "申请部门名称", notes = "不能为空")
    @NotBlank
    private String applyDeptName;

    @ApiModelProperty(name = "申请日期/创建日期", notes = "申请日期也是当时的创建日期，不能为空")
    @NotNull
    private Date createTime;

    @ApiModelProperty(name = "申请人/创建人", notes = "申请人既是创建人，不能为空")
    @NotBlank
    private String createBy;

    @ApiModelProperty(name = "项目名称", notes = "名称和编号都要传，不能为空")
    @NotBlank
    private String projectName;

    @ApiModelProperty(name = "项目编号", notes = "名称和编号都要传，不能为空")
    @NotBlank
    private String projectCode;

    @ApiModelProperty(name = "所属板块/借调人办板块")
    private String loanerPlate;

    @ApiModelProperty(name = "负责部门编号", notes = "不能为空")
    @NotBlank
    private String responsibleDeptCode;

    @ApiModelProperty(name = "负责部门名称", notes = "不能为空")
    @NotBlank
    private String responsibleDeptName;

    @ApiModelProperty(name = "执业地点", notes = "不能为空")
    @NotBlank
    private String address;

    @ApiModelProperty(name = "被借调人板块", notes = "不能为空")
    @NotBlank
    private String loanedPersonPlate;

    @ApiModelProperty(name = "借调协调人", notes = "不能为空")
    @NotBlank
    private String coordinator;

    @ApiModelProperty(name = "结算方式")
    private String settlement;

    @ApiModelProperty(name = "状态")
    private String state;

    @ApiModelProperty(name = "其他要求")
    private String others;

    @ApiModelProperty(name = "借调需求集合")
    private List<SecondmentDemandEntity> secondmentDemandEntityList;

    @ApiModelProperty(name = "借调人员表集合")
    private List<SecondmentPeoplesEntity> secondmentPeoplesEntityList;

    @ApiModelProperty(name = "用户日志")
    private SysLogEntity sysLogEntity;

}



