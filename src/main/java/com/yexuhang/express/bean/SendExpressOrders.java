package com.yexuhang.express.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 发快递订单表
 * </p>
 *
 * @author Xuhang Ye
 * @since 2026-01-22
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("send_express_orders")
public class SendExpressOrders implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 寄件订单ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 寄件用户ID
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
     * 寄件码（快递员取件用）
     */
    private String sendCode;

    /**
     * 寄件人姓名
     */
    private String senderName;

    /**
     * 寄件人电话
     */
    private String senderPhone;

    /**
     * 寄件人地址
     */
    private String senderAddress;

    /**
     * 收件人姓名
     */
    private String receiverName;

    /**
     * 收件人电话
     */
    private String receiverPhone;

    /**
     * 收件人地址
     */
    private String receiverAddress;

    /**
     * 预估重量(kg)
     */
    private BigDecimal estimatedWeight;

    /**
     * 预估费用
     */
    private BigDecimal estimatedCost;

    /**
     * 订单状态
     */
    private String status;

    /**
     * 存件时间
     */
    private LocalDateTime storeTime;

    /**
     * 快递员取件时间
     */
    private LocalDateTime pickTime;

    /**
     * 取件快递员ID
     */
    private Long courierId;

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
