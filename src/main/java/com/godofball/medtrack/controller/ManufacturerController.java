package com.godofball.medtrack.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.godofball.medtrack.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/manufacturer")
@RestController
@Slf4j
public class ManufacturerController {
  @GetMapping("/page")
    public Result<Page> page(){
      return null;
  }
}
