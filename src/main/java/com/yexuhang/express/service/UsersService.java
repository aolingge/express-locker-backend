package com.yexuhang.express.service;

import com.yexuhang.express.bean.Users;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yexuhang.express.config.CommonResult;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author Xuhang Ye
 * @since 2026-01-16
 */
public interface UsersService extends IService<Users> {
    CommonResult<?> loginByUsername(String username, String password);
    CommonResult<?> register(String username, String password1, String password2, String phone);
    CommonResult<?> updatePassword(String username, String oldPassword, String newPassword1, String newPassword2);
    CommonResult<?> authenticateUser(String username, String realName, String idCard);
}
