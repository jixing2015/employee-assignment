package com.sw.basis.service.impl;

import com.sw.basis.dto.api.RankRateDTO;
import com.sw.basis.entity.RankRateEntity;
import com.sw.basis.mapper.RankRateMapper;
import com.sw.basis.service.RankRateService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 职级费率 服务实现类
 * </p>
 *
 * @author jixing2000
 * @since 2022-07-29
 */
@Service
public class RankRateServiceImpl extends ServiceImpl<RankRateMapper, RankRateEntity> implements RankRateService {

    /**
     * 同步职级费率
     *
     * @param dtoList 职级费率集合
     **/
    @Override
    public void pushRankRate(List<RankRateDTO> dtoList) {
        List<RankRateEntity> list = new ArrayList<>();
        for(RankRateDTO dto : dtoList){
            RankRateEntity entity = new RankRateEntity();
            BeanUtils.copyProperties(dto,entity);
            list.add(entity);
        }
        this.saveOrUpdateBatch(list);
    }
}
