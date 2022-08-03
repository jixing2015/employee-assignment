package com.sw.basis.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sw.basis.dto.api.DeptRolesDTO;
import com.sw.basis.dto.response.SysDictDTO;
import com.sw.basis.entity.DeptRolesEntity;
import com.sw.basis.mapper.DeptRolesMapper;
import com.sw.basis.service.DeptRolesService;
import com.sw.basis.utils.Responses;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 部门角色 服务实现类
 * </p>
 *
 * @author jixing2000
 * @since 2022-07-29
 */
@Service
public class DeptRolesServiceImpl extends ServiceImpl<DeptRolesMapper, DeptRolesEntity> implements DeptRolesService {

    @Resource
    DeptRolesMapper deptRolesMapper;

    /**
     * 同步部门角色及人员
     *
     * @param dtoList 部门角色及人员集合
     **/
    @Override
    public void pushDeptRoles(List<DeptRolesDTO> dtoList) {
        List<DeptRolesEntity> list = new ArrayList<>();
        for(DeptRolesDTO dto : dtoList){
            DeptRolesEntity entity = new DeptRolesEntity();
            entity.preInsert();
            entity.setAsorgrole(dto.getAsorgrole());
            entity.setAsorgroleName(dto.getAsorgroleName());
            entity.setAsorgroleempEmpid(dto.getAsorgroleempEmpid());
            list.add(entity);
        }
        this.saveOrUpdateBatch(list);
    }

    /**
     * 部门角色字典
     *
     * @return 字典集合
     **/
    @Override
    public Responses<List<SysDictDTO>> deptRolesDict() {
        QueryWrapper<DeptRolesEntity> wrapper = new QueryWrapper<>();
        wrapper.select("DISTINCT asorgrole,asorgrole_name").orderByAsc("asorgrole");
        List<DeptRolesEntity> list = deptRolesMapper.selectList(wrapper);
        List<SysDictDTO> dictList = new ArrayList<>();
        for(DeptRolesEntity entity : list){
            SysDictDTO dto = new SysDictDTO();
            dto.setCode("userLevel");
            dto.setName("职级字典");
            dto.setItemKey(entity.getAsorgrole());
            dto.setItemValue(entity.getAsorgroleName());
            dictList.add(dto);
        }
        return Responses.success(dictList);
    }
}
