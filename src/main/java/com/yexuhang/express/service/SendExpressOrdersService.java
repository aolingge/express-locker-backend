package com.yexuhang.express.service;

import com.yexuhang.express.bean.SendExpressOrders;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yexuhang.express.config.CommonResult;
import com.yexuhang.express.dto.SendOrderDTO;

import java.util.List;

/**
 * <p>
 * 发快递订单表 服务类
 * </p>
 *
 * @author Xuhang Ye
 * @since 2026-01-22
 */
public interface SendExpressOrdersService extends IService<SendExpressOrders> {
    CommonResult<?> sendExpress(SendOrderDTO sendOrderDTO);
    CommonResult<List<SendExpressOrders>> getOrdersByCourierId(Long courierId);
    CommonResult<?> pickExpress(String sendCode);
}
