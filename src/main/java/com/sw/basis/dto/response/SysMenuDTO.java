package com.sw.basis.dto.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * <p>
 * 权限表
 * </p>
 *
 * @author jixing2000
 * @since 2022-07-07
 */
@ApiModel(value = "权限 DTO")
@Data
public class SysMenuDTO {

    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "菜单编号")
    private String menuCode;

    @ApiModelProperty(value = "菜单名称")
    private String menuName;

    @ApiModelProperty(value = "资源路径")
    private String url;

    @ApiModelProperty(value = "菜单类型;0，层级(没有按钮没有权限)；1，列表；2，按钮；")
    private Integer menuType;

    @ApiModelProperty(value = "父级菜单编号")
    private String parentCode;

    @ApiModelProperty(value = "说明")
    private String description;

    @ApiModelProperty(value = "数据权限")
    private String dataRole;

    @ApiModelProperty(value = "子集")
    private List<SysMenuDTO> children;

}
