package com.sw.basis.dto.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * 部门角色DTO
 *
 * @author jixing2000
 * @since 2022-07-29
 */
@ApiModel(value = "部门角色DTO")
@Data
public class DeptRolesDTO {

    @ApiModelProperty(value = "角色（部门负责经理，部门秘书）")
    private String asorgrole;

    @ApiModelProperty(value = "角色名称（部门负责经理，部门秘书）")
    private String asorgroleName;

    @ApiModelProperty(value = "员工编号")
    private String asorgroleempEmpid;

}