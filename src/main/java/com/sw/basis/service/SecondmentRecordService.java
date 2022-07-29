package com.sw.basis.service;

import com.sw.basis.dto.response.SecondmentRecordDTO;
import com.sw.basis.entity.SecondmentRecordEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sw.basis.utils.Responses;

import java.util.List;

/**
 * <p>
 * 借调记录 服务类
 * </p>
 *
 * @author donglinmo
 * @since 2022-07-26
 */
public interface SecondmentRecordService extends IService<SecondmentRecordEntity> {

    /**
     * 校验
     * @param
     *
     * @return List<SecondmentRecordDTO> 查询借调记录的结果集
     **/
    List<SecondmentRecordDTO> selectSecondmentRecord();
}
