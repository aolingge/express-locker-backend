package com.yexuhang.express.service.impl;

import com.yexuhang.express.bean.Cabinets;
import com.yexuhang.express.config.CommonResult;
import com.yexuhang.express.mapper.CabinetsMapper;
import com.yexuhang.express.service.CabinetsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
