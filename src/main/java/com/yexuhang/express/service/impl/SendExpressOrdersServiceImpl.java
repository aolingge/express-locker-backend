package com.yexuhang.express.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yexuhang.express.bean.SendExpressOrders;
import com.yexuhang.express.config.CommonResult;
import com.yexuhang.express.dto.SendOrderDTO;
import com.yexuhang.express.mapper.SendExpressOrdersMapper;
import com.yexuhang.express.service.SendExpressOrdersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 发快递订单表 服务实现类
 * </p>
 *
 * @author Xuhang Ye
 * @since 2026-01-22
 */
@Service
public class SendExpressOrdersServiceImpl extends ServiceImpl<SendExpressOrdersMapper, SendExpressOrders> implements SendExpressOrdersService {
    @Autowired
    private SendExpressOrdersMapper sendExpressOrdersMapper;

    @Override
    public CommonResult<?> sendExpress(SendOrderDTO sendOrderDTO) {
        // 创建新的发快递订单对象
        SendExpressOrders newOrder = new SendExpressOrders();
        newOrder.setUserId(sendOrderDTO.getUserId());
        newOrder.setCabinetId(sendOrderDTO.getCabinetId());
        newOrder.setDoorId(sendOrderDTO.getDoorId());
        newOrder.setSenderName(sendOrderDTO.getSenderName());
        newOrder.setSenderPhone(sendOrderDTO.getSenderPhone());
        newOrder.setSenderAddress(sendOrderDTO.getSenderAddress());
        newOrder.setReceiverName(sendOrderDTO.getReceiverName());
        newOrder.setReceiverPhone(sendOrderDTO.getReceiverPhone());
        newOrder.setReceiverAddress(sendOrderDTO.getReceiverAddress());
        newOrder.setEstimatedWeight(sendOrderDTO.getEstimatedWeight());
        newOrder.setEstimatedCost(sendOrderDTO.getEstimatedCost());
        newOrder.setNotes(sendOrderDTO.getNotes());
        newOrder.setCourierId(sendOrderDTO.getCourierId());
        newOrder.setStatus("PENDING");

        // 生成唯一的随机六位寄件码
        int sendCode = 100000 + (int)(Math.random() * 900000);
        newOrder.setSendCode(String.valueOf(sendCode));

        // 将新订单保存到数据库
        int result = sendExpressOrdersMapper.insert(newOrder);
        if (result > 0) {
            return CommonResult.success("发快递订单创建成功, 寄件码为: " + sendCode);
        } else {
            return CommonResult.error("发快递订单创建失败, 请稍后再试");
        }
    }

    @Override
    public CommonResult<List<SendExpressOrders>> getOrdersByCourierId(Long courierId) {
        QueryWrapper<SendExpressOrders> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("courier_id", courierId);
        List<SendExpressOrders> orders = sendExpressOrdersMapper.selectList(queryWrapper);
        return CommonResult.success(orders);
    }

}
