package com.sw.basis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sw.basis.entity.SecondmentPeoplesEntity;

import java.util.List;

/**
 * <p>
 * 借调人员 服务类
 * </p>
 *
 * @author jixing2000
 * @since 2022-07-07
 */
public interface SecondmentPeoplesService extends IService<SecondmentPeoplesEntity> {

    List<SecondmentPeoplesEntity> getSecondmentPeoplesEntityList(List<SecondmentPeoplesEntity> secondmentPeoplesEntityList);
}
