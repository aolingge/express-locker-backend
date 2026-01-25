package com.yexuhang.express.service.impl;

import com.yexuhang.express.bean.ExpressOrders;
import com.yexuhang.express.config.CommonResult;
import com.yexuhang.express.dto.CourierStoreDTO;
import com.yexuhang.express.mapper.ExpressOrdersMapper;
import com.yexuhang.express.service.ExpressOrdersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

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
}
