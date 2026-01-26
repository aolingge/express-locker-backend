package com.yexuhang.express.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yexuhang.express.bean.Users;
import com.yexuhang.express.config.CommonResult;
import com.yexuhang.express.mapper.UsersMapper;
import com.yexuhang.express.service.UsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author Xuhang Ye
 * @since 2026-01-16
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {
    @Autowired
    private UsersMapper usersMapper;

    // 用户名密码登录
    @Override
    public CommonResult<?> loginByUsername(String username, String password) {
        QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username).eq("password", password);
        return CommonResult.success(usersMapper.selectOne(queryWrapper));
    }

    // 实现注册并完成两次密码输入的校验
    @Override
    public CommonResult<?> register(String username, String password1, String password2, String phone) {
        // 检查用户名是否已经存在
        QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        Users existingUser = usersMapper.selectOne(queryWrapper);
        if (existingUser != null) {
            return CommonResult.error("用户名已存在");
        }

        // 检查手机号是否已经存在
        QueryWrapper<Users> phoneQueryWrapper = new QueryWrapper<>();
        phoneQueryWrapper.eq("phone", phone);
        Users existingPhoneUser = usersMapper.selectOne(phoneQueryWrapper);
        if (existingPhoneUser != null) {
            return CommonResult.error("手机号已被注册");
        }

        // 检查两次密码是否一致
        if (!password1.equals(password2)) {
            return CommonResult.error("两次密码输入不一致, 请重新输入");
        }

        // 创建新用户对象并保存到数据库
        Users newUser = new Users();
        newUser.setUsername(username);
        newUser.setPassword(password1);
        newUser.setPhone(phone);

        int result = usersMapper.insert(newUser);
        if (result > 0) {
            return CommonResult.success("注册成功");
        } else {
            return CommonResult.error("注册失败, 请稍后再试");
        }
    }

    // 修改密码
    @Override
    public CommonResult<?> updatePassword(String username, String oldPassword, String newPassword1, String newPassword2) {
        QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username).eq("password", oldPassword);
        Users existingUser = usersMapper.selectOne(queryWrapper);

        if (existingUser == null) {
            return CommonResult.error("原密码错误");
        }

        // 检查两次新密码是否一致
        if (!newPassword1.equals(newPassword2)) {
            return CommonResult.error("两次新密码输入不一致, 请重新输入");
        }

        // 更新密码
        existingUser.setPassword(newPassword1);
        int result = usersMapper.updateById(existingUser);
        if (result > 0) {
            return CommonResult.success("密码修改成功");
        } else {
            return CommonResult.error("密码修改失败, 请稍后再试");
        }
    }

    // 实名认证，添加真名与身份证号
    public CommonResult<?> authenticateUser(String username, String realName, String idCard) {
        QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        Users existingUser = usersMapper.selectOne(queryWrapper);

        if (existingUser == null) {
            return CommonResult.error("用户不存在");
        }

        // 更新真实姓名和身份证号
        existingUser.setRealName(realName);
        existingUser.setIdCard(idCard);
        int result = usersMapper.updateById(existingUser);
        if (result > 0) {
            return CommonResult.success("实名认证成功");
        } else {
            return CommonResult.error("实名认证失败, 请稍后再试");
        }
    }

    // 管理员登录
    public CommonResult<?> adminLogin(String username, String password) {
        QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username).eq("password", password).eq("user_type", "ADMIN");
        Users adminUser = usersMapper.selectOne(queryWrapper);
        if (adminUser != null) {
            return CommonResult.success(adminUser);
        } else {
            return CommonResult.error("管理员登录失败, 用户名或密码错误");
        }
    }

    // 获取所有普通用户信息
    public CommonResult<List<Users>> getAllNormalUsers() {
        QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_type", "NORMAL");
        List<Users> userList = usersMapper.selectList(queryWrapper);
        return CommonResult.success(userList);
    }

    // 查看某一用户的详细信息
    public CommonResult<?> getUserDetails(String username) {
        QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        Users user = usersMapper.selectOne(queryWrapper);
        if (user != null) {
            return CommonResult.success(user);
        } else {
            return CommonResult.error("用户不存在");
        }
    }

    // 封禁与解封用户
    public CommonResult<?> setUserStatus(String username) {
        QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        Users user = usersMapper.selectOne(queryWrapper);
        if (user == null) {
            return CommonResult.error("用户不存在");
        }

        if ("ACTIVE".equals(user.getStatus())) {
            user.setStatus("BANNED");
        } else {
            user.setStatus("ACTIVE");
        }
        int result = usersMapper.updateById(user);
        if (result > 0) {
            return CommonResult.success("用户状态更新成功, 当前状态为 " + user.getStatus());
        } else {
            return CommonResult.error("用户状态更新失败");
        }
    }

    // 获取所有快递员信息
    public CommonResult<List<Users>> getAllCouriers() {
        QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_type", "COURIER");
        List<Users> courierList = usersMapper.selectList(queryWrapper);
        return CommonResult.success(courierList);
    }
}
