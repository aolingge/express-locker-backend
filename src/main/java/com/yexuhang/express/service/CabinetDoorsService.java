package com.yexuhang.express.service;

import com.yexuhang.express.bean.CabinetDoors;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yexuhang.express.config.CommonResult;

import java.util.List;

/**
 * <p>
 * 仓门表 服务类
 * </p>
 *
 * @author Xuhang Ye
 * @since 2026-01-22
 */
public interface CabinetDoorsService extends IService<CabinetDoors> {
    CommonResult<List<CabinetDoors>> getAvailableDoorsBySizeAndCabinetId(String sizeType, String cabinetId);
}
