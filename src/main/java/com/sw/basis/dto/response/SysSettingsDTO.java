package com.sw.basis.dto.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * <p>
 * 系统设置 DTO
 * </p>
 *
 * @author jixing2000
 * @since 2022-07-07
 */
@ApiModel(value = "系统设置 DTO")
@Data
public class SysSettingsDTO {

    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "所属板块")
    private String plage;

    @ApiModelProperty(value = "每人每日可派遣项目数量上限（天）")
    private Integer projectNumMax;

    @ApiModelProperty(value = "每人每日可派遣工时数上限（h）")
    private Integer workHoursMax;

    @ApiModelProperty(value = "最大派遣周期（天）")
    private Integer cycleMax;

    @ApiModelProperty(value = "是否跨部门派遣;0否；1是；")
    private Integer crossDept;

    @ApiModelProperty(value = "是否跨条线派遣;0否；1是；")
    private Integer crossLine;

    @ApiModelProperty(value = "项目派工成本与预计时间成本最大比例")
    private Integer dispatchEstimatePercent;

    @ApiModelProperty(value = "创建人")
    private String createBy;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新人")
    private String updateBy;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "是否删除;0表示未删除，1表示删除")
    private Integer delFlag;

}
