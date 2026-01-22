package com.yexuhang.express.controller;

import com.yexuhang.express.config.CommonResult;
import com.yexuhang.express.service.UsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author Xuhang Ye
 * @since 2026-01-16
 */
@RestController
@Slf4j
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UsersController {
    @Autowired
    private UsersService usersService;

    // 登录接口
    @PostMapping("/login/username")
    public CommonResult<?> loginByUsername(@RequestParam String username, @RequestParam String password) {
        log.info("Login attempt with username: {}", username);

        CommonResult<?> user = usersService.loginByUsername(username, password);

        if (user != null) {
            log.info("User logged in successfully: {}", username);
            return CommonResult.success(user);
        } else {
            log.warn("Login failed for username: {}", username);
            return CommonResult.error("用户名或密码错误");
        }
    }

    // 注册接口
    @PostMapping("/register")
    public CommonResult<?> register(@RequestParam String username, @RequestParam String password1, @RequestParam String password2, @RequestParam String phone) {
        log.info("Register attempt with username: {}", username);

        return usersService.register(username, password1, password2, phone);
    }

    // 修改密码接口
    @PostMapping("/updatePassword")
    public CommonResult<?> updatePassword(@RequestParam String username, @RequestParam String oldPassword,
                                         @RequestParam String newPassword1, @RequestParam String newPassword2) {
        log.info("Password update attempt for username: {}", username);
        return usersService.updatePassword(username, oldPassword, newPassword1, newPassword2);}


}
