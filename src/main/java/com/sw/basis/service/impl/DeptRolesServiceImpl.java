package com.sw.basis.service.impl;

import com.sw.basis.dto.api.DeptRolesDTO;
import com.sw.basis.entity.DeptRolesEntity;
import com.sw.basis.mapper.DeptRolesMapper;
import com.sw.basis.service.DeptRolesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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
}
