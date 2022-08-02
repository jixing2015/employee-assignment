package com.sw.basis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sw.basis.dto.api.VacationDTO;
import com.sw.basis.entity.SysVacationEntity;
import com.sw.basis.mapper.SysVacationMapper;
import com.sw.basis.service.SysVacationService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 休假表 服务实现类
 * </p>
 *
 * @author jixing2000
 * @since 2022-08-02
 */
@Service
public class SysVacationServiceImpl extends ServiceImpl<SysVacationMapper, SysVacationEntity> implements SysVacationService {

    /**
     * 同步休假信息
     *
     * @param dtoList 休假信息集合
     **/
    @Override
    public void pushVacation(List<VacationDTO> dtoList) {
        List<SysVacationEntity> list = dtoList.stream().map(vacationDTO -> {
            SysVacationEntity entity = new SysVacationEntity();
            BeanUtils.copyProperties(vacationDTO,entity);
            return entity;
        }).collect(Collectors.toList());
        this.saveOrUpdateBatch(list);
    }
}
