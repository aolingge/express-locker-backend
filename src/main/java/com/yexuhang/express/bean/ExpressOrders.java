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
 * 快递订单表
 * </p>
 *
 * @author Xuhang Ye
 * @since 2026-01-22
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("express_orders")
public class ExpressOrders implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单ID（生成规则：时间戳+随机数）
     */
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    /**
     * 快递单号
     */
    private String trackingNumber;

    /**
     * 快递员ID
     */
    private Long courierId;

    /**
     * 寄件人姓名
     */
    private String senderName;

    /**
     * 寄件人电话
     */
    private String senderPhone;

    /**
     * 收件人姓名
     */
    private String receiverName;

    /**
     * 收件人电话
     */
    private String receiverPhone;

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
     * 订单状态
     */
    private String status;

    /**
     * 存件时间
     */
    private LocalDateTime storeTime;

    /**
     * 取件时间
     */
    private LocalDateTime pickTime;

    /**
     * 过期时间（存件后72小时）
     */
    private LocalDateTime expireTime;

    /**
     * 快递尺寸
     */
    private String sizeType;

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
