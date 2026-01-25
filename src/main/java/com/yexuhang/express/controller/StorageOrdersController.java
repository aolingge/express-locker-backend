package com.yexuhang.express.controller;

import com.yexuhang.express.config.CommonResult;
import com.yexuhang.express.dto.StoreOrderDTO;
import com.yexuhang.express.service.StorageOrdersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 寄存订单表 前端控制器
 * </p>
 *
 * @author Xuhang Ye
 * @since 2026-01-22
 */
@RestController
@Slf4j
@RequestMapping("/storageOrders")
@CrossOrigin(origins = "*")
public class StorageOrdersController {
    @Autowired
    private StorageOrdersService storageOrdersService;

    @PostMapping("/storeExpress")
    public CommonResult<?> storeExpressOrders(@RequestBody StoreOrderDTO storeOrderDTO) {
        log.info("Received store express order: {}", storeOrderDTO);
        return storageOrdersService.storeExpress(storeOrderDTO);
    }

    @PostMapping("/pickExpress")
    public CommonResult<?> pickExpressOrders(@RequestParam String pickCode) {
        log.info("Received pick express order request with pickCode: {}", pickCode);
        return storageOrdersService.pickExpress(pickCode);
    }
}
