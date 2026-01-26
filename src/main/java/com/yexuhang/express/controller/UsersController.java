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
        return usersService.updatePassword(username, oldPassword, newPassword1, newPassword2);
    }

    // 实名认证接口
    @PostMapping("/authenticate")
    public CommonResult<?> authenticateUser(@RequestParam String username, @RequestParam String realName,
                                           @RequestParam String idCard) {
        log.info("Authentication attempt for username: {}", username);
        return usersService.authenticateUser(username, realName, idCard);
    }

    // 管理员登录接口
    @PostMapping("/admin/login")
    public CommonResult<?> adminLogin(@RequestParam String username, @RequestParam String password) {
        log.info("Admin login attempt with username: {}", username);
        return usersService.adminLogin(username, password);
    }

    // 获取所有普通用户接口
    @GetMapping("/allNormalUsers")
    public CommonResult<?> getAllNormalUsers() {
        log.info("Fetching all normal users");
        return usersService.getAllNormalUsers();
    }

    // 获取用户详情接口
    @GetMapping("/details")
    public CommonResult<?> getUserDetails(@RequestParam String username) {
        log.info("Fetching details for username: {}", username);
        return usersService.getUserDetails(username);
    }

    // 禁用与启用用户接口
    @PostMapping("/setStatus")
    public CommonResult<?> setUserStatus(@RequestParam String username) {
        log.info("Setting status for username: {}", username);
        return usersService.setUserStatus(username);
    }

    // 获取所有快递员接口
    @GetMapping("/allCouriers")
    public CommonResult<?> getAllCouriers() {
        log.info("Fetching all couriers");
        return usersService.getAllCouriers();
    }
}
