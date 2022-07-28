package com.sw.basis.dto.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 角色表（岗位）PageDTO
 * </p>
 *
 * @author jixing2000
 * @since 2022-07-07
 */
@ApiModel(value = "岗位 PageDTO")
@Data
public class SysRolePageDTO {

    @ApiModelProperty(value = "角色编号")
    private String roleCode;

    @ApiModelProperty(value = "角色名称")
    private String roleName;

    @ApiModelProperty(value = "状态;0已启用,1已停用")
    private Integer state;

}
