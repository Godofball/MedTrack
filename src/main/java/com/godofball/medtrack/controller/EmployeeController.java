package com.godofball.medtrack.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.godofball.medtrack.common.Result;
import com.godofball.medtrack.pojo.Employee;
import com.godofball.medtrack.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/login")
    public Result<String> login(Employee employee, HttpSession session){
        String username = employee.getUsername();
        String password = DigestUtils.md5DigestAsHex(employee.getPassword().getBytes());

        //判断员工是否存在
        LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Employee::getUsername,username);
        employee = employeeService.getOne(queryWrapper);
        if (employee==null){
            return Result.error("账号不存在");
        }

        //判断密码是否正确
        if (!password.equals(employee.getPassword())){
            return Result.error("密码错误");
        }

        session.setAttribute("admin",employee.getId());
return null;
    }

}
