package com.sw.basis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sw.basis.dto.response.SysMenuDTO;
import com.sw.basis.entity.SysMenuEntity;
import com.sw.basis.utils.Responses;

import java.util.List;

/**
 * <p>
 * 权限表 服务类
 * </p>
 *
 * @author jixing2000
 * @since 2022-07-07
 */
public interface SysMenuService extends IService<SysMenuEntity> {

    /**
     * 根据角色查询菜单树
     * @param roleCode 角色编号
     *
     * @return 菜单树
     **/
    Responses<List<SysMenuDTO>> tree(String roleCode);

    /**
     * 有标记的菜单树
     * @param roleCode 角色编号
     *
     * @return 有标记的菜单树
     **/
    List<SysMenuDTO> treeDetail(String roleCode);
}
