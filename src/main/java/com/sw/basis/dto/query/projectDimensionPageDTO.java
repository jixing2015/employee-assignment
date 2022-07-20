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

    @ApiModelProperty(value = "板块编号")
    private String plageCode;

    @ApiModelProperty(value = "区域编号")
    private String areaCode;

    @ApiModelProperty(value = "业务条线编号")
    private String lineCode;

    @ApiModelProperty(value = "部门编号")
    private String deptCode;

}
