package com.sw.basis.dto.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * 员工档案DTO
 *
 * @author jixing2000
 * @since 2022-07-29
 */
@ApiModel(value = "员工档案DTO")
@Data
public class UserDTO {

    @ApiModelProperty(value = "员工编号")
    private String hrempCode;

    @ApiModelProperty(value = "姓名")
    private String hrempName;

    @ApiModelProperty(value = "状态")
    private Integer hrempStatus;

    @ApiModelProperty(value = "部门编号")
    private String asorgOrgid;

    @ApiModelProperty(value = "部门名称")
    private String asorgOrgname;

    @ApiModelProperty(value = "职级编号")
    private String hrjobJob;

    @ApiModelProperty(value = "职级名称")
    private String hrjobJobname;

    @ApiModelProperty(value = "人才基地")
    private String hrempTalentbase;
}