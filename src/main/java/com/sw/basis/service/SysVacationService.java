package com.sw.basis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sw.basis.dto.api.VacationDTO;
import com.sw.basis.entity.SysVacationEntity;

import java.util.List;

/**
 * <p>
 * 休假表 服务类
 * </p>
 *
 * @author jixing2000
 * @since 2022-08-02
 */
public interface SysVacationService extends IService<SysVacationEntity> {

    /**
     * 同步休假信息
     * @param dtoList 休假信息集合
     *
     **/
    void pushVacation(List<VacationDTO> dtoList);
}
