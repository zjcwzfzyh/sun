package com.lfxwkj.sun.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
* <p>
* 项目的检测项
* </p>
*
* @author 张永辉
* @since 2020-09-16
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ToString(callSuper = true)
@TableName("tbl_gb_item_check")
@ApiModel(value="ItemCheck对象", description="项目的检测项")
public class ItemCheck implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "项目主键")
    @TableField("item_name")
    private Long itemName;

    @ApiModelProperty(value = "项目名称")
    @TableField("item_code")
    private String itemCode;

    @ApiModelProperty(value = "备注")
    @TableField("remarks")
    private String remarks;

    @ApiModelProperty(value = "状态")
    @TableField("state")
    private Integer state;

    @ApiModelProperty(value = "添加时间")
    @TableField("add_time")
    private LocalDateTime addTime;

    @ApiModelProperty(value = "添加人")
    @TableField("add_user")
    private Long addUser;

    @ApiModelProperty(value = "检测项名称")
    @TableField("check_name")
    private String checkName;

    @ApiModelProperty(value = "开始时间")
    @TableField("start_time")
    private LocalDateTime startTime;

    @ApiModelProperty(value = "结束时间")
    @TableField("end_time")
    private LocalDateTime endTime;

    @ApiModelProperty(value = "检测设备主键拼串")
    @TableField("sub_ids")
    private String subIds;


}