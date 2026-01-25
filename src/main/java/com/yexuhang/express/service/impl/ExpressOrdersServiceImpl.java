package com.yexuhang.express.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.yexuhang.express.bean.ExpressOrders;
import com.yexuhang.express.config.CommonResult;
import com.yexuhang.express.dto.CourierStoreDTO;
import com.yexuhang.express.mapper.ExpressOrdersMapper;
import com.yexuhang.express.service.ExpressOrdersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <p>
 * 快递订单表 服务实现类
 * </p>
 *
 * @author Xuhang Ye
 * @since 2026-01-22
 */
@Service
public class ExpressOrdersServiceImpl extends ServiceImpl<ExpressOrdersMapper, ExpressOrders> implements ExpressOrdersService {
    @Autowired
    private ExpressOrdersMapper expressOrdersMapper;

    public CommonResult<List<ExpressOrders>> getAllExpressOrders(String cabinetId, String receiverPhone) {
        QueryWrapper<ExpressOrders> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("cabinet_id", cabinetId);
        queryWrapper.eq("receiver_phone", receiverPhone);
        queryWrapper.eq("status", "STORED");
        List<ExpressOrders> orders = expressOrdersMapper.selectList(queryWrapper);

        if (orders != null && !orders.isEmpty()) {
            return CommonResult.success(orders);
        } else {
            return CommonResult.error("未找到相关快递订单");
        }
    }

    public CommonResult<?> pickAllExpressOrders(String cabinetId, String receiverPhone) {
        ExpressOrders updateState = new ExpressOrders();
        updateState.setStatus("PICKED")
                .setPickTime(java.time.LocalDateTime.now());

        UpdateWrapper<ExpressOrders> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("cabinet_id", cabinetId)
                .eq("receiver_phone", receiverPhone)
                .eq("status", "STORED");

        expressOrdersMapper.update(updateState, updateWrapper);

        return CommonResult.success("所有快递订单已取件");
    }

    public CommonResult<?> pickExpressOrderByPickCode(String pickCode) {
        ExpressOrders updateState = new ExpressOrders();
        updateState.setStatus("PICKED")
                .setPickTime(java.time.LocalDateTime.now());

        UpdateWrapper<ExpressOrders> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("pick_code", pickCode)
                .eq("status", "STORED");

        int rowsAffected = expressOrdersMapper.update(updateState, updateWrapper);
        if (rowsAffected > 0) {
            return CommonResult.success("快递订单已取件");
        } else {
            return CommonResult.error("未找到对应的快递订单或订单已被取件");
        }
    }
}
