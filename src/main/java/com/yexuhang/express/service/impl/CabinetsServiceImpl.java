package com.yexuhang.express.service.impl;

import com.yexuhang.express.bean.Cabinets;
import com.yexuhang.express.config.CommonResult;
import com.yexuhang.express.mapper.CabinetsMapper;
import com.yexuhang.express.service.CabinetsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 快递柜表 服务实现类
 * </p>
 *
 * @author Xuhang Ye
 * @since 2026-01-22
 */
@Service
public class CabinetsServiceImpl extends ServiceImpl<CabinetsMapper, Cabinets> implements CabinetsService {
    @Autowired
    private CabinetsMapper cabinetsMapper;

    // 查询设备总数
    public CommonResult<List<Cabinets>> getAllCabinets() {
        List<Cabinets> cabinetsList = cabinetsMapper.selectList(null);
        return CommonResult.success(cabinetsList);
    }

    // 添加设备
    public CommonResult<?> addCabinet(String id, String name, String location, Integer totalDoors) {
        Cabinets cabinet = new Cabinets();
        cabinet.setId(id);
        cabinet.setName(name);
        cabinet.setLocation(location);
        cabinet.setTotalDoors(totalDoors);
        cabinet.setAvailableDoors(totalDoors);
        cabinet.setLastHeartbeat(java.time.LocalDateTime.now());
        int result = cabinetsMapper.insert(cabinet);
        if (result > 0) {
            return CommonResult.success("Cabinet added successfully");
        } else {
            return CommonResult.error("Failed to add cabinet");
        }
    }

    // 删除设备
    public CommonResult<?> deleteCabinet(String id) {
        int result = cabinetsMapper.deleteById(id);
        if (result > 0) {
            return CommonResult.success("Cabinet deleted successfully");
        } else {
            return CommonResult.error("Failed to delete cabinet");
        }
    }

    // 禁用与启用设备
    public CommonResult<?> setCabinetStatus(String id) {
        Cabinets cabinet = cabinetsMapper.selectById(id);
        if (cabinet == null) {
            return CommonResult.error("Cabinet not found");
        }

        if ("NORMAL".equals(cabinet.getStatus())) {
            cabinet.setStatus("MAINTENANCE");
        } else {
            cabinet.setStatus("NORMAL");
        }
        int result = cabinetsMapper.updateById(cabinet);
        if (result > 0) {
            return CommonResult.success("Cabinet status updated successfully and is now " + cabinet.getStatus());
        } else {
            return CommonResult.error("Failed to update cabinet status");
        }
    }
}
