package com.yexuhang.express.controller;

import com.yexuhang.express.bean.Cabinets;
import com.yexuhang.express.config.CommonResult;
import com.yexuhang.express.service.CabinetsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 快递柜表 前端控制器
 * </p>
 *
 * @author Xuhang Ye
 * @since 2026-01-22
 */
@RestController
@Slf4j
@RequestMapping("/cabinets")
@CrossOrigin(origins = "*")
public class CabinetsController {
    @Autowired
    private CabinetsService cabinetsService;

    @PostMapping("/all")
    public CommonResult<List<Cabinets>> getAllCabinets() {
        log.info("Fetching all cabinets");
        return cabinetsService.getAllCabinets();
    }

    @PostMapping("/add")
    public CommonResult<?> addCabinet(String id, String name, String location, Integer totalDoors) {
        log.info("Adding cabinet with id: {}, name: {}, location: {}, totalDoors: {}", id, name, location, totalDoors);
        return cabinetsService.addCabinet(id, name, location, totalDoors);
    }

    @PostMapping("/delete")
    public CommonResult<?> deleteCabinet(String id) {
        log.info("Deleting cabinet with id: {}", id);
        return cabinetsService.deleteCabinet(id);
    }

    @PostMapping("/setStatus")
    public CommonResult<?> setCabinetStatus(String id) {
        log.info("Setting status for cabinet with id: {}", id);
        return cabinetsService.setCabinetStatus(id);
    }
}
