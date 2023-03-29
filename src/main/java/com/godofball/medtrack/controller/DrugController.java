package com.godofball.medtrack.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.godofball.medtrack.common.Result;
import com.godofball.medtrack.pojo.Drug;
import com.godofball.medtrack.service.DrugService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/drug")
@RestController
@Slf4j
public class DrugController {

    @Autowired
    private DrugService drugService;

    @GetMapping("/page")
    public Result<Page> page(@RequestParam(value = "page",defaultValue = "1")Integer page,
                             @RequestParam(value = "pageSize",defaultValue = "10")Integer pageSize,
                             String name){
        Page<Drug> pageInfo = new Page<>(page, pageSize);
        LambdaQueryWrapper<Drug> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StringUtils.hasLength(name),Drug::getName,name);
        drugService.page(pageInfo,queryWrapper);
        return Result.success(pageInfo);
    }

}
