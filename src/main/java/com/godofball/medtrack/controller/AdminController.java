package com.godofball.medtrack.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.godofball.medtrack.common.Result;
import com.godofball.medtrack.pojo.Admin;
import com.godofball.medtrack.pojo.Employee;
import com.godofball.medtrack.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    public Result login(@RequestBody Admin admin, HttpSession session){
        String username = admin.getUsername();
        String password = DigestUtils.md5DigestAsHex(admin.getPassword().getBytes());

        //判断员工是否存在
        LambdaQueryWrapper<Admin> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Admin::getUsername,username);
        admin = adminService.getOne(queryWrapper);
        if (admin==null){
            return Result.error("账号不存在");
        }

        //判断密码是否正确
        if (!password.equals(admin.getPassword())){
            return Result.error("密码错误");
        }

        session.setAttribute("admin",admin.getId());
        admin.setPassword(null);
        return Result.success(admin);
    }

    @PostMapping("/logout")
    public Result<String> logout(HttpSession session){
        session.removeAttribute("admin");
        return Result.success("退出成功");
    }
}
