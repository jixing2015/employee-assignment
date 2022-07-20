package com.sw.basis.dto.query;

import com.sw.basis.utils.vo.Pageable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 系统设置 PageDTO
 * </p>
 *
 * @author jixing2000
 * @since 2022-07-07
 */
@ApiModel(value = "系统设置 PageDTO")
@Data
public class SysSettingsPageDTO extends Pageable {

    @ApiModelProperty(value = "所属板块")
    private String plageCode;

}
