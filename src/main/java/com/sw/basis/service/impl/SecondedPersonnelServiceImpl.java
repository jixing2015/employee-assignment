package com.sw.basis.service.impl;

import com.sw.basis.dto.api.SecondedPersonnelDTO;
import com.sw.basis.entity.SecondedPersonnelEntity;
import com.sw.basis.mapper.SecondedPersonnelMapper;
import com.sw.basis.service.SecondedPersonnelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 人员借调批量设置 服务实现类
 * </p>
 *
 * @author jixing2000
 * @since 2022-07-29
 */
@Service
public class SecondedPersonnelServiceImpl extends ServiceImpl<SecondedPersonnelMapper, SecondedPersonnelEntity> implements SecondedPersonnelService {

    /**
     * 同步人员借调批量设置
     *
     * @param dtoList 人员借调批量设置集合
     **/
    @Override
    public void pushSecondedPersonnel(List<SecondedPersonnelDTO> dtoList) {
        List<SecondedPersonnelEntity> list = new ArrayList<>();
        for(SecondedPersonnelDTO dto : dtoList){
            SecondedPersonnelEntity entity = new SecondedPersonnelEntity();
            BeanUtils.copyProperties(dto,entity);
            entity.preInsert();
            list.add(entity);
        }
        this.saveOrUpdateBatch(list);
    }
}
