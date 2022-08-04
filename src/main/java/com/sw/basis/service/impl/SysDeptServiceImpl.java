package com.sw.basis.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sw.basis.dto.api.OrganizationDTO;
import com.sw.basis.dto.query.DeptQuery;
import com.sw.basis.dto.request.DepartmentInformationDTO;
import com.sw.basis.dto.response.SysDictDTO;
import com.sw.basis.entity.SysDeptEntity;
import com.sw.basis.mapper.SysDeptMapper;
import com.sw.basis.service.SysDeptService;
import com.sw.basis.utils.Responses;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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

    /**
     * 同步组织机构信息
     *
     * @param dtoList 组织机构信息集合
     **/
    @Override
    public void pushOrganization(List<OrganizationDTO> dtoList) {
        List<SysDeptEntity> list = new ArrayList<>();
        for(OrganizationDTO dto : dtoList){
            SysDeptEntity entity = new SysDeptEntity();
            entity.preInsert();
            entity.setDeptCode(dto.getAsorgOrgid());
            entity.setDeptName(dto.getAsorgOrgname());
            entity.setPlageCode(dto.getAsorgBusinessline());
            entity.setPlageName(dto.getAsorgBusinesslineName());
            entity.setAsorgAreaCode(dto.getAsorgArea());
            entity.setAsorgAreaName(dto.getAsorgAreaName());
            entity.setLineCode(dto.getAsorgBusinessline());
            entity.setLineName(dto.getAsorgBusinesslineName());
            list.add(entity);
        }
        this.saveOrUpdateBatch(list);
    }

    /**
     * 部门字典
     *
     * @return 字典集合
     **/
    @Override
    public Responses<List<SysDictDTO>> deptDict(DeptQuery deptQuery) {
        if(deptQuery.getType() == null){
            return Responses.error("类型不能为空");
        }
        else if(deptQuery.getType() != 0 && deptQuery.getType() != 1 && deptQuery.getType() != 2 && deptQuery.getType() != 3) {
            return Responses.error("请输入正确的类型");
        }
        QueryWrapper<SysDeptEntity> wrapper = new QueryWrapper<>();
        wrapper.select("DISTINCT dept_code,dept_name");
        if(deptQuery.getType() == 1){
            wrapper.lambda().eq(SysDeptEntity::getPlageCode,deptQuery.getCode());
        }
        else if(deptQuery.getType() == 2){
            wrapper.lambda().eq(SysDeptEntity::getAsorgAreaCode,deptQuery.getCode());
        }
        else if(deptQuery.getType() == 3){
            wrapper.lambda().eq(SysDeptEntity::getLineCode,deptQuery.getCode());
        }
        wrapper.orderByAsc("dept_code");
        List<SysDeptEntity> list = sysDeptMapper.selectList(wrapper);
        List<SysDictDTO> dictList = new ArrayList<>();
        for(SysDeptEntity entity : list){
            SysDictDTO dto = new SysDictDTO();
            dto.setCode("deptDict");
            dto.setName("部门字典");
            dto.setItemKey(entity.getDeptCode());
            dto.setItemValue(entity.getDeptName());
            dictList.add(dto);
        }
        return Responses.success(dictList);
    }

    /**
     * 板块字典
     *
     * @return 字典集合
     **/
    @Override
    public Responses<List<SysDictDTO>> plageDict() {
        QueryWrapper<SysDeptEntity> wrapper = new QueryWrapper<>();
        wrapper.select("DISTINCT plage_code,plage_name").orderByAsc("plage_code");
        List<SysDeptEntity> list = sysDeptMapper.selectList(wrapper);
        List<SysDictDTO> dictList = new ArrayList<>();
        for(SysDeptEntity entity : list){
            SysDictDTO dto = new SysDictDTO();
            dto.setCode("plageDict");
            dto.setName("板块字典");
            dto.setItemKey(entity.getPlageCode());
            dto.setItemValue(entity.getPlageName());
            dictList.add(dto);
        }
        return Responses.success(dictList);
    }

    /**
     * 区域字典
     *
     * @return 字典集合
     **/
    @Override
    public Responses<List<SysDictDTO>> areaDict() {
        QueryWrapper<SysDeptEntity> wrapper = new QueryWrapper<>();
        wrapper.select("DISTINCT asorg_area_code,asorg_area_name").orderByAsc("asorg_area_code");
        List<SysDeptEntity> list = sysDeptMapper.selectList(wrapper);
        List<SysDictDTO> dictList = new ArrayList<>();
        for(SysDeptEntity entity : list){
            SysDictDTO dto = new SysDictDTO();
            dto.setCode("areaDict");
            dto.setName("区域字典");
            dto.setItemKey(entity.getAsorgAreaCode());
            dto.setItemValue(entity.getAsorgAreaName());
            dictList.add(dto);
        }
        return Responses.success(dictList);
    }

    /**
     * 业务条线字典
     *
     * @return 字典集合
     **/
    @Override
    public Responses<List<SysDictDTO>> lineDict() {
        QueryWrapper<SysDeptEntity> wrapper = new QueryWrapper<>();
        wrapper.select("DISTINCT line_code,line_name").orderByAsc("line_code");
        List<SysDeptEntity> list = sysDeptMapper.selectList(wrapper);
        List<SysDictDTO> dictList = new ArrayList<>();
        for(SysDeptEntity entity : list){
            SysDictDTO dto = new SysDictDTO();
            dto.setCode("lineDict");
            dto.setName("业务条线字典");
            dto.setItemKey(entity.getLineCode());
            dto.setItemValue(entity.getLineName());
            dictList.add(dto);
        }
        return Responses.success(dictList);
    }


}
