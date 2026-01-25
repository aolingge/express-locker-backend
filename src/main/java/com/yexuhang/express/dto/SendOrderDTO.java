package com.yexuhang.express.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SendOrderDTO {
    private Long userId;
    private String cabinetId;
    private Long doorId;
    private String senderName;
    private String senderPhone;
    private String senderAddress;
    private String receiverName;
    private String receiverPhone;
    private String receiverAddress;
    private BigDecimal estimatedWeight;
    private BigDecimal estimatedCost;
    private String notes;
    private Long courierId;
}
