package com.godofball.medtrack.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.godofball.medtrack.mapper.EmployeeMapper;
import com.godofball.medtrack.pojo.Employee;
import com.godofball.medtrack.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
}
