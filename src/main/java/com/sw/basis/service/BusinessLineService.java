package com.sw.basis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sw.basis.dto.api.BusinessLineDTO;
import com.sw.basis.entity.BusinessLineEntity;

import java.util.List;

/**
 * <p>
 * 业务线设置 服务类
 * </p>
 *
 * @author jixing2000
 * @since 2022-07-29
 */
public interface BusinessLineService extends IService<BusinessLineEntity> {

    /**
     * 同步业务线设置
     * @param dtoList 业务线设置信息
     *
     **/
    void pushBusinessLine(List<BusinessLineDTO> dtoList);
}
