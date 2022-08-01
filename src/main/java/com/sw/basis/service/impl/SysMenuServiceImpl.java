package com.sw.basis.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sw.basis.dto.response.SysMenuDTO;
import com.sw.basis.entity.SysMenuEntity;
import com.sw.basis.entity.SysRoleMenuEntity;
import com.sw.basis.mapper.SysMenuMapper;
import com.sw.basis.mapper.SysRoleMenuMapper;
import com.sw.basis.service.SysMenuService;
import com.sw.basis.utils.Responses;
import com.sw.basis.utils.constant.StateConstant;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author jixing2000
 * @since 2022-07-07
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenuEntity> implements SysMenuService {

    @Resource
    SysMenuMapper sysMenuMapper;
    @Resource
    SysRoleMenuMapper sysRoleMenuMapper;

    /**
     * 根据角色查询菜单树
     *
     * @param roleCode 角色编号
     * @return 菜单树
     **/
    @Override
    public Responses<List<SysMenuDTO>> tree(String roleCode) {
        QueryWrapper<SysMenuEntity> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SysMenuEntity::getDelFlag,StateConstant.UN_DEL);
        wrapper.lambda().orderByAsc(SysMenuEntity::getParentCode);
        List<SysMenuEntity> list = sysMenuMapper.selectList(wrapper);

        List<SysMenuDTO> tempMenuDTOList = list.stream().map(sysMenuEntity -> {
            SysMenuDTO dto = new SysMenuDTO();
            BeanUtils.copyProperties(sysMenuEntity,dto);
            return dto;
        }).collect(Collectors.toList());

        List<SysMenuDTO> result = this.assembleTree(tempMenuDTOList);

        return Responses.success(result);
    }

    /**
     * 组装树
     * @param list 所有的分支
     *
     * @return 树
     **/
    private List<SysMenuDTO> assembleTree(List<SysMenuDTO> list){
        Map<String,List<SysMenuDTO>> parentCodeMenuDTOMap = new HashMap<>();
        List<SysMenuDTO> sysMenuDTOList = new ArrayList<>();
        for(SysMenuDTO sysMenuDTO : list){
            sysMenuDTOList.add(sysMenuDTO);

            String parentCode = sysMenuDTO.getParentCode();
            if(parentCodeMenuDTOMap.containsKey(parentCode)){
                List<SysMenuDTO> sysMenuDTOList2 = parentCodeMenuDTOMap.get(parentCode);
                sysMenuDTOList2.add(sysMenuDTO);
            }
            else{
                List<SysMenuDTO> sysMenuDTOList2 = new ArrayList<>();
                sysMenuDTOList2.add(sysMenuDTO);
                parentCodeMenuDTOMap.put(parentCode,sysMenuDTOList2);
            }
        }
        for(SysMenuDTO sysMenuDTO : sysMenuDTOList){
            List<SysMenuDTO> sysMenuDTOList3 = parentCodeMenuDTOMap.get(sysMenuDTO.getMenuCode());
            sysMenuDTO.setChildren(sysMenuDTOList3);
        }
        List<SysMenuDTO> result = parentCodeMenuDTOMap.get(null);
        return result;
    }

    /**
     * 有标记的菜单树
     *
     * @param roleCode 角色编号
     * @return 有标记的菜单树
     **/
    @Override
    public List<SysMenuDTO> treeDetail(String roleCode) {
        QueryWrapper<SysMenuEntity> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SysMenuEntity::getDelFlag,StateConstant.UN_DEL);
        wrapper.lambda().orderByAsc(SysMenuEntity::getParentCode);
        List<SysMenuEntity> list = sysMenuMapper.selectList(wrapper);
        List<SysMenuDTO> tempMenuDTOList = list.stream().map(sysMenuEntity -> {
            SysMenuDTO dto = new SysMenuDTO();
            BeanUtils.copyProperties(sysMenuEntity,dto);
            return dto;
        }).collect(Collectors.toList());
        //查询岗位菜单
        QueryWrapper<SysRoleMenuEntity> roleMenuWrapper = new QueryWrapper<>();
        roleMenuWrapper.lambda().eq(SysRoleMenuEntity::getDelFlag, StateConstant.UN_DEL);
        roleMenuWrapper.lambda().eq(SysRoleMenuEntity::getRoleCode, roleCode);
        List<SysRoleMenuEntity> sysRoleMenuEntityList = sysRoleMenuMapper.selectList(roleMenuWrapper);
        if(tempMenuDTOList != null && tempMenuDTOList.size() > 0 && sysRoleMenuEntityList != null && sysRoleMenuEntityList.size() > 0){
            for(SysMenuDTO sysMenuDTO : tempMenuDTOList){
                sysMenuDTO.setIsCheck(false);
                for(SysRoleMenuEntity sysRoleMenuEntity : sysRoleMenuEntityList){
                    if(sysMenuDTO.getMenuCode().equals(sysRoleMenuEntity.getMenuCode())){
                        sysMenuDTO.setDataRole(sysRoleMenuEntity.getDataRole());
                        sysMenuDTO.setIsCheck(true);
                    }
                }
            }
        }
        List<SysMenuDTO> result = this.assembleTree(tempMenuDTOList);
        return result;
    }
}
