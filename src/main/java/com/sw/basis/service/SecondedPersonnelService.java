package com.sw.basis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sw.basis.dto.api.SecondedPersonnelDTO;
import com.sw.basis.entity.SecondedPersonnelEntity;

import java.util.List;

/**
 * <p>
 * 人员借调批量设置 服务类
 * </p>
 *
 * @author jixing2000
 * @since 2022-07-29
 */
public interface SecondedPersonnelService extends IService<SecondedPersonnelEntity> {

    /**
     * 同步人员借调批量设置
     * @param dtoList 人员借调批量设置集合
     *
     **/
    void pushSecondedPersonnel(List<SecondedPersonnelDTO>dtoList);
}
