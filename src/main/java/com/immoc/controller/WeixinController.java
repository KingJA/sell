package com.immoc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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

        String url="https://api.weixin.qq" +
                ".com/sns/oauth2/access_token?appid=wx7d839658461e64a9&secret=f0a34449f810996cb543beca75939208&code" +
                "="+code+"&grant_type=authorization_code";
        RestTemplate restTemplate = new RestTemplate();
        String access_token = restTemplate.getForObject(url, String.class);
        log.error("access_token={}",access_token);

    }
}
