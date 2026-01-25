package com.yexuhang.express.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class StoreOrderDTO {
    private Long userId;
    private String cabinetId;
    private Long doorId;
    private String pickCode;
    private String itemDescription;
}
