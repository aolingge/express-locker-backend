package com.yexuhang.express.controller;

import com.yexuhang.express.config.CommonResult;
import com.yexuhang.express.dto.SendOrderDTO;
import com.yexuhang.express.service.SendExpressOrdersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 发快递订单表 前端控制器
 * </p>
 *
 * @author Xuhang Ye
 * @since 2026-01-22
 */
@RestController
@Slf4j
@RequestMapping("/sendExpressOrders")
@CrossOrigin(origins = "*")
public class SendExpressOrdersController {
    @Autowired
    private SendExpressOrdersService sendExpressOrdersService;

    @PostMapping("/sendExpress")
    public CommonResult<?> sendExpress(@RequestBody SendOrderDTO sendOrderDTO) {
        log.info("Received send express order: {}", sendOrderDTO);
        return sendExpressOrdersService.sendExpress(sendOrderDTO);
    }

    @GetMapping("/{courierId}/orders")
    public CommonResult<?> getOrdersByCourierId(@PathVariable Long courierId) {
        log.info("Fetching orders for courierId: {}", courierId);
        return sendExpressOrdersService.getOrdersByCourierId(courierId);
    }
}
