package com.godofball.medtrack.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.godofball.medtrack.common.Result;
import com.godofball.medtrack.pojo.Employee;
import com.godofball.medtrack.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/employee")
@Slf4j
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

    @GetMapping("/page")
    public Result<Page> page(@RequestParam(value = "page",defaultValue = "1") Integer page,
                             @RequestParam(value = "pageSize",defaultValue = "10")Integer pageSize,
                             String name){
        Page<Employee> pageInfo = new Page<>(page,pageSize);
        LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(StringUtils.hasLength(name),Employee::getName,name);
        employeeService.page(pageInfo,queryWrapper);
        pageInfo.getRecords().forEach(employee -> employee.setPassword(""));
        return Result.success(pageInfo);
    }

    @PostMapping
    public Result addEmployee(@RequestBody Employee employee){
        log.info(employee.toString());
        String password = DigestUtils.md5DigestAsHex("123456".getBytes());
        employee.setPassword(password);
        employee.setStatus(1);
        employeeService.save(employee);
        log.info(employee.toString());
        return Result.success("添加成功");
    }

    @GetMapping("/{id}")
    public Result<Employee> getById(@PathVariable("id") Long id){
        Employee employee = employeeService.getById(id);
        return Result.success(employee);
    }

    @PutMapping
    public Result<String> update(@RequestBody Employee employee){
        log.info(employee.toString());
        employeeService.updateById(employee);
        return Result.success("员工信息修改成功！");
    }

}
