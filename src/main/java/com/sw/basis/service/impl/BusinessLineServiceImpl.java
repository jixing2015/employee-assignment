package com.sw.basis.service.impl;

import com.sw.basis.dto.api.BusinessLineDTO;
import com.sw.basis.entity.BusinessLineEntity;
import com.sw.basis.mapper.BusinessLineMapper;
import com.sw.basis.service.BusinessLineService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 业务线设置 服务实现类
 * </p>
 *
 * @author jixing2000
 * @since 2022-07-29
 */
@Service
public class BusinessLineServiceImpl extends ServiceImpl<BusinessLineMapper, BusinessLineEntity> implements BusinessLineService {

    /**
     * 同步业务线设置
     *
     * @param dtoList 业务线设置信息
     **/
    @Override
    public void pushBusinessLine(List<BusinessLineDTO> dtoList) {
        List<BusinessLineEntity> list = new ArrayList<>();
        for(BusinessLineDTO dto : dtoList){
            BusinessLineEntity entity = new BusinessLineEntity();
            BeanUtils.copyProperties(dto,entity);
            entity.preInsert();
            list.add(entity);
        }
        this.saveOrUpdateBatch(list);
    }
}
