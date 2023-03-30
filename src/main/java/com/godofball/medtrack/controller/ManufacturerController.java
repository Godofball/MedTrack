package com.godofball.medtrack.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.godofball.medtrack.common.Result;
import com.godofball.medtrack.pojo.Manufacturer;
import com.godofball.medtrack.service.ManufacturerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/manufacturer")
@RestController
@Slf4j
public class ManufacturerController {

  @Autowired
  private ManufacturerService manufacturerService;

  @GetMapping("/page")
    public Result<Page> page(@RequestParam(value = "page",defaultValue = "1")Integer page,
                             @RequestParam(value = "pageSize",defaultValue = "10")Integer pageSize,
                             String name){
    log.info("page:{},pageSize:{},name:{}",page,pageSize,name);
    Page<Manufacturer> pageInfo = new Page<>();

    LambdaQueryWrapper<Manufacturer> queryWrapper = new LambdaQueryWrapper<>();
    queryWrapper.like(StringUtils.hasLength(name),Manufacturer::getName,name);

    manufacturerService.page(pageInfo,queryWrapper);

    return Result.success(pageInfo);
  }
}
