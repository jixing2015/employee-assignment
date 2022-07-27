package com.sw.basis.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sw.basis.dto.response.SysMenuDTO;
import com.sw.basis.entity.SysMenuEntity;
import com.sw.basis.mapper.SysMenuMapper;
import com.sw.basis.service.SysMenuService;
import com.sw.basis.utils.Responses;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /**
     * 根据角色查询菜单树
     *
     * @param roleCode 角色编号
     * @return 菜单树
     **/
    @Override
    public Responses<List<SysMenuDTO>> tree(String roleCode) {
        QueryWrapper<SysMenuEntity> wrapper = new QueryWrapper<>();
        wrapper.lambda().orderByAsc(SysMenuEntity::getParentCode);
        List<SysMenuEntity> list = sysMenuMapper.selectList(wrapper);

        Map<String,List<SysMenuDTO>> parentCodeMenuDTOMap = new HashMap<>();
        List<SysMenuDTO> sysMenuDTOList = new ArrayList<>();
        for(SysMenuEntity entity : list){
            SysMenuDTO sysMenuDTO = new SysMenuDTO();
            BeanUtils.copyProperties(entity,sysMenuDTO);
            sysMenuDTOList.add(sysMenuDTO);

            String parentCode = entity.getParentCode();
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

        return Responses.success(result);
    }
}
