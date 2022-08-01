package com.sw.basis.dto.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 组织机构DTO
 *
 * @author jixing2000
 * @since 2022-08-01
 */
@ApiModel(value = "组织机构DTO")
@Data
public class OrganizationDTO {

    @ApiModelProperty(value = "部门编号")
    private String asorgOrgid;

    @ApiModelProperty(value = "部门名称")
    private String asorgOrgname;

    @ApiModelProperty(value = "父级部门编号")
    private String parentCode;

    @ApiModelProperty(value = "板块编号")
    private String asorgBusinesstype;

    @ApiModelProperty(value = "板块名称")
    private String asorgBusinesstypeName;

    @ApiModelProperty(value = "区域编号")
    private String asorgArea;

    @ApiModelProperty(value = "区域名称")
    private String asorgAreaName;

    @ApiModelProperty(value = "条线编号")
    private String asorgBusinessline;

    @ApiModelProperty(value = "条线名称")
    private String asorgBusinesslineName;

}
