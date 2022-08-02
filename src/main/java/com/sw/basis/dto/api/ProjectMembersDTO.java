package com.sw.basis.dto.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;


/**
 * 项目组成员信息DTO
 *
 * @author jixing2000
 * @since 2022-07-29
 */
@ApiModel(value = "项目组成员信息DTO")
@Data
public class ProjectMembersDTO {

    @ApiModelProperty(value = "单据编号")
    private String pmresResid;

    @ApiModelProperty(value = "员工工号")
    private String pmresRescode;

    @ApiModelProperty(value = "员工姓名")
    private String pmresName;

    @ApiModelProperty(value = "部门id")
    private String pmresEntity;

    @ApiModelProperty(value = "部门编号")
    private String asorgOrgcode;

    @ApiModelProperty(value = "部门名称")
    private String asorgOrgname;

    @ApiModelProperty(value = "派遣开始日期")
    private Date pmprjresFromdate;

    @ApiModelProperty(value = "派遣结束日期")
    private Date pmprjresTodate;

}