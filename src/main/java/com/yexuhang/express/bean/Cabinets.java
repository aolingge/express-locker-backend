package com.yexuhang.express.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 快递柜表
 * </p>
 *
 * @author Xuhang Ye
 * @since 2026-01-22
 */
@Getter
@Setter
@Accessors(chain = true)
public class Cabinets implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 快递柜ID（如：CAB001）
     */
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    /**
     * 快递柜名称
     */
    private String name;

    /**
     * 安装位置
     */
    private String location;

    /**
     * 详细地址
     */
    private String addressDetail;

    /**
     * 纬度
     */
    private BigDecimal latitude;

    /**
     * 经度
     */
    private BigDecimal longitude;

    /**
     * 柜体状态
     */
    private String status;

    /**
     * 总仓门数量
     */
    private Integer totalDoors;

    /**
     * 可用仓门数量
     */
    private Integer availableDoors;

    /**
     * 电源状态
     */
    private String powerStatus;

    /**
     * 网络状态
     */
    private String networkStatus;

    /**
     * 最后心跳时间
     */
    private LocalDateTime lastHeartbeat;

    /**
     * 创建时间
     */
    private LocalDateTime createdAt;

    /**
     * 更新时间
     */
    private LocalDateTime updatedAt;
}
