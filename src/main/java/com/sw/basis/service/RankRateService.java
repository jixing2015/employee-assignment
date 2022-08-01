package com.sw.basis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sw.basis.dto.api.RankRateDTO;
import com.sw.basis.entity.RankRateEntity;

import java.util.List;

/**
 * <p>
 * 职级费率 服务类
 * </p>
 *
 * @author jixing2000
 * @since 2022-07-29
 */
public interface RankRateService extends IService<RankRateEntity> {

    /**
     * 同步职级费率
     * @param dtoList 职级费率集合
     *
     **/
    void pushRankRate(List<RankRateDTO> dtoList);
}
