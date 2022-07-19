package com.sw.basis.dto.query;

import com.sw.basis.utils.vo.Pageable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 人员维度派遣 pageDTO
 * </p>
 *
 * @author jixing2000
 * @since 2022-07-07
 */
@ApiModel(value = "人员维度派遣 pageDTO")
@Data
public class projectDimensionPageDTO extends Pageable {

    @ApiModelProperty(value = "板块")
    private String plage;

    @ApiModelProperty(value = "区域")
    private String area;

    @ApiModelProperty(value = "业务条线")
    private String line;

    @ApiModelProperty(value = "部门编号")
    private String deptCode;

}
