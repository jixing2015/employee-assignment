package com.sw.basis.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sw.basis.dto.query.SysRolePageDTO;
import com.sw.basis.dto.request.SysRoleModifyDTO;
import com.sw.basis.dto.request.SysUserModifyDTO;
import com.sw.basis.dto.response.SysMenuDTO;
import com.sw.basis.dto.response.SysRoleDTO;
import com.sw.basis.entity.SysRoleEntity;
import com.sw.basis.entity.SysRoleMenuEntity;
import com.sw.basis.entity.SysUserRoleEntity;
import com.sw.basis.mapper.SysRoleMapper;
import com.sw.basis.mapper.SysRoleMenuMapper;
import com.sw.basis.mapper.SysUserRoleMapper;
import com.sw.basis.service.SysMenuService;
import com.sw.basis.service.SysRoleMenuService;
import com.sw.basis.service.SysRoleService;
import com.sw.basis.service.SysUserRoleService;
import com.sw.basis.utils.LocalUserUtil;
import com.sw.basis.utils.Responses;
import com.sw.basis.utils.constant.StateConstant;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 岗位管理 服务实现类
 * </p>
 *
 * @author jixing2000
 * @since 2022-07-07
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRoleEntity> implements SysRoleService {

    @Resource
    SysRoleMapper sysRoleMapper;
    @Resource
    SysRoleMenuService sysRoleMenuService;
    @Resource
    SysUserRoleService sysUserRoleService;
    @Resource
    SysUserRoleMapper sysUserRoleMapper;
    @Resource
    SysMenuService sysMenuService;
    @Resource
    SysRoleMenuMapper sysRoleMenuMapper;

    /**
     * 岗位管理_列表
     *
     * @param dto 查询条件
     * @return 分页列表
     **/
    @Override
    public Responses<List<SysRoleDTO>> page(SysRolePageDTO dto) {
        QueryWrapper<SysRoleEntity> wrapper = new QueryWrapper<>();
        wrapper.lambda().like(StringUtils.isNotEmpty(dto.getRoleCode()),SysRoleEntity::getRoleCode,dto.getRoleCode());
        wrapper.lambda().like(StringUtils.isNotEmpty(dto.getRoleName()),SysRoleEntity::getRoleName,dto.getRoleName());
        wrapper.lambda().eq(dto.getState()!=null,SysRoleEntity::getState,dto.getState());
        wrapper.lambda().orderByDesc(SysRoleEntity::getId);
        List<SysRoleEntity> result = sysRoleMapper.selectList(wrapper);
        return Responses.success(
            result.stream().map(sysRoleEntity -> {
                SysRoleDTO sysRoleDTO = new SysRoleDTO();
                BeanUtils.copyProperties(sysRoleEntity,sysRoleDTO);
                return sysRoleDTO;
            }).collect(Collectors.toList())
        );
    }

    /**
     * 岗位管理_新增
     *
     * @param dto 岗位信息
     * @return 成功/失败
     **/
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Responses<String> add(SysRoleModifyDTO dto) {
        SysRoleEntity sysRoleEntity = new SysRoleEntity();
        BeanUtils.copyProperties(dto,sysRoleEntity);
        sysRoleEntity.setState(StateConstant.ENABLE);
        sysRoleEntity.preInsert();
        sysRoleMapper.insert(sysRoleEntity);
        //增加岗位与权限关系
        List<SysMenuDTO> sysMenuDTOList = dto.getMenuTree();
        List<SysRoleMenuEntity> sysRoleMenuEntityList = new ArrayList<>();
        for(SysMenuDTO sysMenuDTO : sysMenuDTOList){
            SysRoleMenuEntity entity = new SysRoleMenuEntity();
            entity.preInsert();
            entity.setRoleCode(sysRoleEntity.getRoleCode());
            entity.setMenuCode(sysMenuDTO.getMenuCode());
            entity.setDataRole(sysMenuDTO.getDataRole());
            sysRoleMenuEntityList.add(entity);
        }
        sysRoleMenuService.saveBatch(sysRoleMenuEntityList);
        //增加岗位与人员关系
        List<SysUserRoleEntity> userRoleEntityList = new ArrayList<>();
        List<SysUserModifyDTO> userList = dto.getUserList();
        for(SysUserModifyDTO modifyDTO : userList){
            SysUserRoleEntity entity = new SysUserRoleEntity();
            entity.preInsert();
            entity.setRoleCode(sysRoleEntity.getRoleCode());
            entity.setUserCode(modifyDTO.getCode());
            entity.setTypes(0);
            userRoleEntityList.add(entity);
        }
        List<SysUserModifyDTO> levelUserList = dto.getByLevelUserList();
        for(SysUserModifyDTO modifyDTO : levelUserList){
            SysUserRoleEntity entity = new SysUserRoleEntity();
            entity.preInsert();
            entity.setRoleCode(sysRoleEntity.getRoleCode());
            entity.setUserCode(modifyDTO.getCode());
            entity.setTypes(1);
            userRoleEntityList.add(entity);
        }
        List<SysUserModifyDTO> roleUserList = dto.getByRoleUserList();
        for(SysUserModifyDTO modifyDTO : roleUserList){
            SysUserRoleEntity entity = new SysUserRoleEntity();
            entity.preInsert();
            entity.setRoleCode(sysRoleEntity.getRoleCode());
            entity.setUserCode(modifyDTO.getCode());
            entity.setTypes(2);
            userRoleEntityList.add(entity);
        }
        sysUserRoleService.saveBatch(userRoleEntityList);
        return Responses.success();
    }

    /**
     * 岗位管理_根据id修改
     *
     * @param dto 岗位信息
     * @return 成功/失败
     **/
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Responses<String> updateById(SysRoleModifyDTO dto) {
        SysRoleEntity sysRoleEntity = new SysRoleEntity();
        BeanUtils.copyProperties(dto,sysRoleEntity);
        String currentUserCode = LocalUserUtil.getCurrentUser() != null ? LocalUserUtil.getCurrentUser().getCode() : null;
        String currentUserName = LocalUserUtil.getCurrentUser() != null ? LocalUserUtil.getCurrentUser().getName() : null;
        Date date = new Date();
        sysRoleEntity.setUpdateBy(currentUserCode);
        sysRoleEntity.setUpdateName(currentUserName);
        sysRoleEntity.setUpdateTime(new Date());
        sysRoleMapper.updateById(sysRoleEntity);
        //增加岗位与权限关系
        List<SysMenuDTO> sysMenuDTOList = dto.getMenuTree();
        List<SysRoleMenuEntity> sysRoleMenuEntityList = new ArrayList<>();
        for(SysMenuDTO sysMenuDTO : sysMenuDTOList){
            SysRoleMenuEntity entity = new SysRoleMenuEntity();
            entity.setRoleCode(sysRoleEntity.getRoleCode());
            if(sysMenuDTO.getId() != null){
                entity.setId(sysMenuDTO.getId());
            }
            else{
                entity.preInsert();
            }
            entity.setMenuCode(sysMenuDTO.getMenuCode());
            entity.setDataRole(sysMenuDTO.getDataRole());
            entity.setUpdateBy(currentUserCode);
            entity.setUpdateTime(date);
            sysRoleMenuEntityList.add(entity);
        }
        sysRoleMenuService.saveOrUpdateBatch(sysRoleMenuEntityList);
        //增加岗位与人员关系
        List<SysUserRoleEntity> userRoleEntityList = new ArrayList<>();
        List<SysUserModifyDTO> userList = dto.getUserList();
        for(SysUserModifyDTO modifyDTO : userList){
            SysUserRoleEntity entity = new SysUserRoleEntity();
            entity.setRoleCode(sysRoleEntity.getRoleCode());
            if(modifyDTO.getId() != null){
                entity.setId(modifyDTO.getId());
            }
            else{
                entity.preInsert();
            }
            entity.setUserCode(modifyDTO.getCode());
            entity.setTypes(0);
            entity.setUpdateBy(currentUserCode);
            entity.setUpdateTime(date);
            userRoleEntityList.add(entity);
        }
        List<SysUserModifyDTO> levelUserList = dto.getByLevelUserList();
        for(SysUserModifyDTO modifyDTO : levelUserList){
            SysUserRoleEntity entity = new SysUserRoleEntity();
            entity.setRoleCode(sysRoleEntity.getRoleCode());
            if(modifyDTO.getId() != null){
                entity.setId(modifyDTO.getId());
            }
            else{
                entity.preInsert();
            }
            entity.setUserCode(modifyDTO.getCode());
            entity.setTypes(1);
            entity.setUpdateBy(currentUserCode);
            entity.setUpdateTime(date);
            userRoleEntityList.add(entity);
        }
        List<SysUserModifyDTO> roleUserList = dto.getByRoleUserList();
        for(SysUserModifyDTO modifyDTO : roleUserList){
            SysUserRoleEntity entity = new SysUserRoleEntity();
            entity.setRoleCode(sysRoleEntity.getRoleCode());
            if(modifyDTO.getId() != null){
                entity.setId(modifyDTO.getId());
            }
            else{
                entity.preInsert();
            }
            entity.setUserCode(modifyDTO.getCode());
            entity.setTypes(2);
            entity.setUpdateBy(currentUserCode);
            entity.setUpdateTime(date);
            userRoleEntityList.add(entity);
        }
        sysUserRoleService.saveOrUpdateBatch(userRoleEntityList);
        return Responses.success();
    }

    /**
     * 岗位管理_禁用
     *
     * @param dto 岗位信息
     * @return 成功/失败
     **/
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Responses<String> disableSwitch(SysRoleModifyDTO dto) {
        SysRoleEntity sysRoleEntity = new SysRoleEntity();
        sysRoleEntity.setId(dto.getId());
        sysRoleEntity.setState(dto.getState());
        sysRoleMapper.updateById(sysRoleEntity);
        return Responses.success();
    }

    /**
     * 岗位管理_详情
     *
     * @param id ID
     * @return 详情
     **/
    @Override
    public Responses<SysRoleDTO> detail(Integer id) {
        SysRoleDTO sysRoleDTO = new SysRoleDTO();
        QueryWrapper<SysRoleEntity> sysRoleWrapper = new QueryWrapper<>();
        sysRoleWrapper.lambda().eq(SysRoleEntity::getId,id);
        sysRoleWrapper.lambda().eq(SysRoleEntity::getDelFlag,StateConstant.UN_DEL);
        List<SysRoleEntity> sysRoleEntityList = sysRoleMapper.selectList(sysRoleWrapper);
        if(sysRoleEntityList != null && sysRoleEntityList.size() > 0){
            BeanUtils.copyProperties(sysRoleEntityList.get(0),sysRoleDTO);
            //查询权限
//            List<SysMenuDTO> sysMenuDTOList = sysMenuService.treeDetail(sysRoleDTO.getRoleCode());
            QueryWrapper<SysRoleMenuEntity> roleMenuWrapper = new QueryWrapper<>();
            roleMenuWrapper.lambda().eq(SysRoleMenuEntity::getDelFlag, StateConstant.UN_DEL);
            roleMenuWrapper.lambda().eq(SysRoleMenuEntity::getRoleCode, sysRoleDTO.getRoleCode());
            List<SysRoleMenuEntity> sysRoleMenuEntityList = sysRoleMenuMapper.selectList(roleMenuWrapper);
            List<SysMenuDTO> sysMenuDTOList = new ArrayList<>();
            for(SysRoleMenuEntity entity : sysRoleMenuEntityList){
                SysMenuDTO sysMenuDTO = new SysMenuDTO();
                sysMenuDTO.setMenuCode(entity.getMenuCode());
                sysMenuDTO.setDataRole(entity.getDataRole());
                sysMenuDTOList.add(sysMenuDTO);
            }
            sysRoleDTO.setMenuTree(sysMenuDTOList);
            //查询岗位用户
            List<SysUserModifyDTO> sysUserModifyDTOList = sysUserRoleMapper.getRoleUserList(sysRoleDTO.getRoleCode());
            if(sysUserModifyDTOList != null && sysUserModifyDTOList.size() > 0){
                List<SysUserModifyDTO> userList = new ArrayList<>();
                List<SysUserModifyDTO> levelUserList = new ArrayList<>();
                List<SysUserModifyDTO> roleUserList = new ArrayList<>();
                for(SysUserModifyDTO sysUserModifyDTO : sysUserModifyDTOList){
                    if(sysUserModifyDTO.getTypes() == 0){
                        userList.add(sysUserModifyDTO);
                    }
                    else if(sysUserModifyDTO.getTypes() == 1){
                        levelUserList.add(sysUserModifyDTO);
                    }
                    else if(sysUserModifyDTO.getTypes() == 2){
                        roleUserList.add(sysUserModifyDTO);
                    }
                }
                sysRoleDTO.setUserList(userList);
                sysRoleDTO.setByLevelUserList(levelUserList);
                sysRoleDTO.setByRoleUserList(roleUserList);
            }
        }else {
            Responses.error("未查询到岗位记录");
        }
        return Responses.success(sysRoleDTO);
    }
}
