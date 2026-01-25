package com.yexuhang.express.controller;

import com.yexuhang.express.bean.CabinetDoors;
import com.yexuhang.express.config.CommonResult;
import com.yexuhang.express.service.CabinetDoorsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 仓门表 前端控制器
 * </p>
 *
 * @author Xuhang Ye
 * @since 2026-01-22
 */
@RestController
@Slf4j
@RequestMapping("/cabinetDoors")
@CrossOrigin(origins = "*")
public class CabinetDoorsController {
    @Autowired
    private CabinetDoorsService cabinetDoorsService;

    @GetMapping("/{cabinetId}/{sizeType}/availableDoors")
    public CommonResult<List<CabinetDoors>> getAvailableDoorsBySizeAndCabinetId(@PathVariable String cabinetId, @PathVariable String sizeType) {
        log.info("Fetching available doors for cabinetId: {}, sizeType: {}", cabinetId, sizeType);
        return cabinetDoorsService.getAvailableDoorsBySizeAndCabinetId(sizeType, cabinetId);
    }
}
