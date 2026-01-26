package com.yexuhang.express.service;

import com.yexuhang.express.bean.Cabinets;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yexuhang.express.config.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p>
 * 快递柜表 服务类
 * </p>
 *
 * @author Xuhang Ye
 * @since 2026-01-22
 */
public interface CabinetsService extends IService<Cabinets> {
    CommonResult<List<Cabinets>> getAllCabinets();
    CommonResult<?> addCabinet(String id, String name, String location, Integer totalDoors);
    CommonResult<?> deleteCabinet(String id);
    CommonResult<?> setCabinetStatus(String id);
}
