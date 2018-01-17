package com.immoc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description：TODO
 * Create Time：2018/1/17 17:12
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
@RestController
@RequestMapping("/weixin")
@Slf4j
public class WeixinController {

    @GetMapping("auth")
    public void auth(@RequestParam("code")String code) {
        log.error("进入微信auth..........");
        log.error("code={}",code);

    }
}
