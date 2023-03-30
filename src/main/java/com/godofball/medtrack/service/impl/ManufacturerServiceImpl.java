package com.godofball.medtrack.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.godofball.medtrack.mapper.ManufacturerMapper;
import com.godofball.medtrack.pojo.Manufacturer;
import com.godofball.medtrack.service.ManufacturerService;
import org.springframework.stereotype.Service;

@Service
public class ManufacturerServiceImpl extends ServiceImpl<ManufacturerMapper, Manufacturer> implements ManufacturerService {
}
