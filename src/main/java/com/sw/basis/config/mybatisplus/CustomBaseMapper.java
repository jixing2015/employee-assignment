package com.sw.basis.config.mybatisplus;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomBaseMapper<T> extends BaseMapper<T> {

    /**
     * 自定义批量新增或更新
     * 如果要自动填充，@Param(xx) xx参数名必须是 list/collection/array 3个的其中之一
     */
    int mysqlSaveOrUpdateBatch(@Param("list")List<T> list);
}
