package com.yexuhang.express.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 寄存订单表
 * </p>
 *
 * @author Xuhang Ye
 * @since 2026-01-22
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("storage_orders")
public class StorageOrders implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 寄存订单ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    /**
     * 寄存用户ID
     */
    private Long userId;

    /**
     * 快递柜ID
     */
    private String cabinetId;

    /**
     * 仓门ID
     */
    private Long doorId;

    /**
     * 取件码
     */
    private String pickCode;

    /**
     * 分享码（可分享给他人）
     */
    private String shareCode;

    /**
     * 物品描述
     */
    private String itemDescription;

    /**
     * 订单状态
     */
    private String status;

    /**
     * 寄存时间
     */
    private LocalDateTime storeTime;

    /**
     * 取件时间
     */
    private LocalDateTime pickTime;

    /**
     * 过期时间
     */
    private LocalDateTime expireTime;

    /**
     * 实际取件人电话（如果分享给他人）
     */
    private String pickerPhone;

    /**
     * 备注
     */
    private String notes;

    /**
     * 创建时间
     */
    private LocalDateTime createdAt;

    /**
     * 更新时间
     */
    private LocalDateTime updatedAt;
}
