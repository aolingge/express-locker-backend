package com.yexuhang.express.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yexuhang.express.bean.CabinetDoors;
import com.yexuhang.express.config.CommonResult;
import com.yexuhang.express.mapper.CabinetDoorsMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yexuhang.express.service.CabinetDoorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 仓门表 服务实现类
 * </p>
 *
 * @author Xuhang Ye
 * @since 2026-01-22
 */
@Service
public class CabinetDoorsServiceImpl extends ServiceImpl<CabinetDoorsMapper, CabinetDoors> implements CabinetDoorsService {
    @Autowired
    private CabinetDoorsMapper cabinetDoorsMapper;

    @Override
    public CommonResult<List<CabinetDoors>> getAvailableDoorsBySizeAndCabinetId(String sizeType, String cabinetId) {
        // 根据快递尺寸，查询指定快递柜下状态为AVAILABLE且尺寸匹配的仓门列表
        QueryWrapper<CabinetDoors> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("size_type", sizeType);
        queryWrapper.eq("cabinet_id", cabinetId);
        queryWrapper.eq("status", "AVAILABLE");
        List<CabinetDoors> availableDoors = cabinetDoorsMapper.selectList(queryWrapper);
        return CommonResult.success(availableDoors);
    }
}
