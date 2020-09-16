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
* 项目表
* </p>
*
* @author 张永辉
* @since 2020-09-16
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ToString(callSuper = true)
@TableName("tbl_gb_item")
@ApiModel(value="Item对象", description="项目表")
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "项目名称")
    @TableField("item_name")
    private String itemName;

    @ApiModelProperty(value = "设备的编号")
    @TableField("item_code")
    private String itemCode;

    @ApiModelProperty(value = "设备种类，与数据字典对应不关联")
    @TableField("item_type")
    private Long itemType;

    @ApiModelProperty(value = "备注")
    @TableField("remarks")
    private String remarks;

    @ApiModelProperty(value = "设备状态， 与数据字典对应不关联")
    @TableField("state")
    private Integer state;

    @ApiModelProperty(value = "添加时间")
    @TableField("add_time")
    private LocalDateTime addTime;

    @ApiModelProperty(value = "添加人")
    @TableField("add_user")
    private Long addUser;


}