package com.sw.basis.dto.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * 人员借调批量设置DTO
 *
 * @author jixing2000
 * @since 2022-07-29
 */
@ApiModel(value = "人员借调批量设置DTO")
@Data
public class SecondedPersonnelDTO {

    @ApiModelProperty(value = "项目负责部门")
    private String pmressetPrjentity;

    @ApiModelProperty(value = "派遣指定部门")
    private String pmressetDispatchentity;

    @ApiModelProperty(value = "派遣指定职级")
    private String pmressetJobid;

}