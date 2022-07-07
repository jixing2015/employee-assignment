package com.sw.basis.utils.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 用于解析Post body中只有id的情况
 * @author jixing2000
 */
@Data
public class IdVO {

    public static IdVO newIdVO(Long id){
        return new IdVO(id);
    }

    @NotNull
    private Long id;

    public IdVO() {
    }

    public IdVO(@NotNull Long id) {
        this.id = id;
    }
}
