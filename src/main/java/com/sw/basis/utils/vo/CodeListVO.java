package com.sw.basis.utils.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * CodeListVO
 * @author jixing2000
 */
@Data
@ApiModel(value = "CodeListVO",description = "编码集合")
public class CodeListVO {

    public static CodeListVO newCodeVO(List<String> code){
        return new CodeListVO(code);
    }

    @ApiModelProperty("编码")
    @NotBlank
    private List<String> code;

    public CodeListVO() {

    }

    public CodeListVO(@NotNull List<String> code) {
        this.code = code;
    }
}
