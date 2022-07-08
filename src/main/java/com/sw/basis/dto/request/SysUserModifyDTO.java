package com.sw.basis.dto.request;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author jixing2000
 * @since 2022-07-07
 */
@ApiModel(value = "用户表 ModifyDTO")
@Data
public class SysUserModifyDTO {

    @ApiModelProperty(value = "主键")
    @TableId
    private Integer id;

    @ApiModelProperty(value = "用户编号")
    private String code;

    @ApiModelProperty(value = "用户名称")
    private String name;

    @ApiModelProperty(value = "部门编号")
    private String deptCode;

    @ApiModelProperty(value = "职级编号")
    private String levelCode;

    @ApiModelProperty(value = "职级名称")
    private String levelName;

    @ApiModelProperty(value = "执业资格")
    private String register;

    @ApiModelProperty(value = "专业编号")
    private String expertType;

    @ApiModelProperty(value = "状态;0，在职；1离职")
    private Integer state;

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
