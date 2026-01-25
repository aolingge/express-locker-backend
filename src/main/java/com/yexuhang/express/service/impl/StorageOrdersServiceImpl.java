package com.yexuhang.express.service.impl;

import com.yexuhang.express.bean.StorageOrders;
import com.yexuhang.express.config.CommonResult;
import com.yexuhang.express.dto.StoreOrderDTO;
import com.yexuhang.express.mapper.StorageOrdersMapper;
import com.yexuhang.express.service.StorageOrdersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 寄存订单表 服务实现类
 * </p>
 *
 * @author Xuhang Ye
 * @since 2026-01-22
 */
@Service
public class StorageOrdersServiceImpl extends ServiceImpl<StorageOrdersMapper, StorageOrders> implements StorageOrdersService {
    @Autowired
    private StorageOrdersMapper storageOrdersMapper;

    public CommonResult<?> storeExpress(StoreOrderDTO storeOrderDTO) {
        // 创建新的寄存订单对象
        StorageOrders storageOrder = new StorageOrders();
        storageOrder.setUserId(storeOrderDTO.getUserId());
        storageOrder.setCabinetId(storeOrderDTO.getCabinetId());
        storageOrder.setDoorId(storeOrderDTO.getDoorId());
        storageOrder.setItemDescription(storeOrderDTO.getItemDescription());
        // 生成唯一的随机六位存件码
        int pickCode = 100000 + (int)(Math.random() * 900000);
        storageOrder.setPickCode(String.valueOf(pickCode));
        storageOrder.setStatus("STORED");

        // 设置存储时间为当前时间
        storageOrder.setStoreTime(java.time.LocalDateTime.now());

        // 设置过期时间为当前时间之后三天
        storageOrder.setExpireTime(java.time.LocalDateTime.now().plusDays(3));

        // 将新订单保存到数据库
        int result = storageOrdersMapper.insert(storageOrder);
        if (result > 0) {
            return CommonResult.success("寄存订单创建成功, 存件码为: " + pickCode);
        } else {
            return CommonResult.error("寄存订单创建失败, 请稍后再试");
        }
    }
}
