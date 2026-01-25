package com.yexuhang.express.dto;

import lombok.Data;

@Data
public class CourierStoreDTO {
    private String cabinetId;
    private Long doorId;
    private String trackingNumber;
    private String receiverPhone;
    private String receiverName;
}
