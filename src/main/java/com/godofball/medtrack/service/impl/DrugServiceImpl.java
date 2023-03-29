package com.godofball.medtrack.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.godofball.medtrack.mapper.DrugMapper;
import com.godofball.medtrack.pojo.Drug;
import com.godofball.medtrack.service.DrugService;
import org.springframework.stereotype.Service;

@Service
public class DrugServiceImpl extends ServiceImpl<DrugMapper, Drug> implements DrugService {
}
