package com.sw.basis.dto.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * 业务线设置DTO
 *
 * @author jixing2000
 * @since 2022-07-29
 */
@ApiModel(value = "业务线设置DTO")
@Data
public class BusinessLineDTO {

    @ApiModelProperty(value = "条线编码")
    private String businesslineCode;

    @ApiModelProperty(value = "条线名称")
    private String businesslineName;

    @ApiModelProperty(value = "板块编号")
    private Integer businesslineBusinesstype;

    @ApiModelProperty(value = "部门编号")
    private String asorgOrgid;

    @ApiModelProperty(value = "部门名称")
    private String asorgOrgname;

}