package com.yexuhang.express.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CourierStoreDTO {
    private Long courierId;
    private String cabinetId;
    private Long doorId;
    private String trackingNumber;
    private String notes;
    private String sizeType;
}
