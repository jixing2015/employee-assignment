package com.sw.basis.dto.request;

import com.sw.basis.dto.response.SysMenuDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * <p>
 * 角色表（岗位）ModifyDTO
 * </p>
 *
 * @author jixing2000
 * @since 2022-07-07
 */
@ApiModel(value = "岗位 ModifyDTO")
@Data
public class SysRoleModifyDTO {

    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "类型：0，普通角色；1,部门角色；2，岗位角色")
    private Integer roleType;

    @ApiModelProperty(value = "角色编号")
    private String roleCode;

    @ApiModelProperty(value = "角色名称")
    private String roleName;

    @ApiModelProperty(value = "状态;0已启用,1已停用")
    private Integer state;

    @ApiModelProperty(value = "权限树")
    List<SysMenuDTO> menuTree;

    @ApiModelProperty(value = "授权用户")
    List<SysUserModifyDTO> userList;

    @ApiModelProperty(value = "职级自动匹配用户")
    List<SysUserModifyDTO> byLevelUserList;

    @ApiModelProperty(value = "角色自动匹配用户")
    List<SysUserModifyDTO> byRoleUserList;
}
