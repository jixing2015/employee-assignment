package com.sw.basis.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sw.basis.entity.SysDeptEntity;
import com.sw.basis.mapper.SysDeptMapper;
import com.sw.basis.service.SysDeptService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 部门表 服务实现类
 * </p>
 *
 * @author jixing2000
 * @since 2022-07-07
 */
@Service
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDeptEntity> implements SysDeptService {

    @Resource
    SysDeptMapper sysDeptMapper;

    /**
     * 根据部门编号获取板块信息
     *
     * @param deptCode 部门编号
     * @return 板块信息
     **/
    @Override
    public SysDeptEntity getPlageByDeptCode(String deptCode) {
        QueryWrapper<SysDeptEntity> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SysDeptEntity::getDeptCode,deptCode);
        List<SysDeptEntity> list = sysDeptMapper.selectList(wrapper);
        SysDeptEntity sysDeptEntity = new SysDeptEntity();
        if(list != null && list.size() > 0){
            sysDeptEntity = list.get(0);
        }
        return sysDeptEntity;
    }
}
