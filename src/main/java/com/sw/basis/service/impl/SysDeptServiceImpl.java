package com.sw.basis.service.impl;

import com.sw.basis.dto.request.DepartmentInformationDTO;
import com.sw.basis.dto.request.FreeBirdInformationDTO;
import com.sw.basis.entity.SysDeptEntity;
import com.sw.basis.mapper.SysDeptMapper;
import com.sw.basis.service.SysDeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sw.basis.utils.Responses;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

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
     * 部门表-新增
     *
     * @param departmentInformationDTO 内容
     * @return 成功/失败
     **/
    @Override
    public Responses<String> insert(DepartmentInformationDTO departmentInformationDTO) {

        SysDeptEntity sysDeptEntity = new SysDeptEntity();
        BeanUtils.copyProperties(departmentInformationDTO, sysDeptEntity);
        sysDeptMapper.insert(sysDeptEntity);
        return Responses.success();
    }





}
