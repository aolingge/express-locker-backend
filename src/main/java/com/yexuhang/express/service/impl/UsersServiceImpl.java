package com.yexuhang.express.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yexuhang.express.bean.Users;
import com.yexuhang.express.config.CommonResult;
import com.yexuhang.express.mapper.UsersMapper;
import com.yexuhang.express.service.UsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
