package com.yexuhang.express.controller;

import com.yexuhang.express.bean.ExpressOrders;
import com.yexuhang.express.config.CommonResult;
import com.yexuhang.express.dto.CourierStoreDTO;
import com.yexuhang.express.service.ExpressOrdersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 快递订单表 前端控制器
 * </p>
 *
 * @author Xuhang Ye
 * @since 2026-01-22
 */
@RestController
@Slf4j
@RequestMapping("/expressOrders")
@CrossOrigin(origins = "*")
public class ExpressOrdersController {
    @Autowired
    private ExpressOrdersService expressOrdersService;

    @PostMapping("/{cabinetId}/getAllExpressOrders")
    public CommonResult<List<ExpressOrders>> getAllExpressOrders(@PathVariable String cabinetId, String receiverPhone) {
        log.info("Fetching all express orders for cabinetId: {}, receiverPhone: {}", cabinetId, receiverPhone);
        return expressOrdersService.getAllExpressOrders(cabinetId, receiverPhone);
    }

    @PostMapping("/{cabinetId}/pickAllExpressOrders")
    public CommonResult<?> pickAllExpressOrders(@PathVariable String cabinetId, String receiverPhone) {
        log.info("Picking all express orders for cabinetId: {}, receiverPhone: {}", cabinetId, receiverPhone);
        return expressOrdersService.pickAllExpressOrders(cabinetId, receiverPhone);
    }

    @PostMapping("/pickExpressOrderByPickCode")
    public CommonResult<?> pickExpressOrderByPickCode(String pickCode) {
        log.info("Picking express order with pickCode: {}", pickCode);
        return expressOrdersService.pickExpressOrderByPickCode(pickCode);
    }

    @PostMapping("/addExpressOrder")
    public CommonResult<?> addExpressOrder(@RequestBody CourierStoreDTO courierStoreDTO) {
        log.info("Adding new express order: {}", courierStoreDTO);
        return expressOrdersService.addExpressOrder(courierStoreDTO);
    }
}
