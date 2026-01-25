package com.yexuhang.express.service;

import com.yexuhang.express.bean.ExpressOrders;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yexuhang.express.config.CommonResult;
import com.yexuhang.express.dto.CourierStoreDTO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p>
 * 快递订单表 服务类
 * </p>
 *
 * @author Xuhang Ye
 * @since 2026-01-22
 */
public interface ExpressOrdersService extends IService<ExpressOrders> {
    CommonResult<List<ExpressOrders>> getAllExpressOrders(String cabinetId, String receiverPhone);
    CommonResult<?> pickAllExpressOrders(String cabinetId, String receiverPhone);
    CommonResult<?> pickExpressOrderByPickCode(String pickCode);
    CommonResult<?> addExpressOrder(CourierStoreDTO courierStoreDTO);
}
