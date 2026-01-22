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
 * 仓门表
 * </p>
 *
 * @author Xuhang Ye
 * @since 2026-01-22
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("cabinet_doors")
public class CabinetDoors implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 仓门ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 所属快递柜ID
     */
    private String cabinetId;

    /**
     * 仓门编号（1-8）
     */
    private Integer doorNumber;

    /**
     * 仓门尺寸类型
     */
    private String sizeType;

    /**
     * 仓门状态
     */
    private String status;

    /**
     * 锁状态
     */
    private String lockStatus;

    /**
     * 是否有物品
     */
    private Boolean hasPackage;

    /**
     * 温度（可选）
     */
    private BigDecimal temperature;

    /**
     * 湿度（可选）
     */
    private BigDecimal humidity;

    /**
     * 压力传感器值
     */
    private BigDecimal pressureValue;

    /**
     * 最后打开时间
     */
    private LocalDateTime lastOpenTime;

    /**
     * 最后关闭时间
     */
    private LocalDateTime lastCloseTime;

    /**
     * 创建时间
     */
    private LocalDateTime createdAt;

    /**
     * 更新时间
     */
    private LocalDateTime updatedAt;
}
