package com.godofball.medtrack.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.godofball.medtrack.mapper.AdminMapper;
import com.godofball.medtrack.pojo.Admin;
import com.godofball.medtrack.service.AdminService;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {
}
