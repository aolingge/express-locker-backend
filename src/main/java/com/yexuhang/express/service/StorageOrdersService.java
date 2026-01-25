package com.yexuhang.express.service;

import com.yexuhang.express.bean.StorageOrders;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yexuhang.express.config.CommonResult;
import com.yexuhang.express.dto.StoreOrderDTO;

/**
 * <p>
 * 寄存订单表 服务类
 * </p>
 *
 * @author Xuhang Ye
 * @since 2026-01-22
 */
public interface StorageOrdersService extends IService<StorageOrders> {
    CommonResult<?> storeExpress(StoreOrderDTO storeOrderDTO);
}
