package com.immoc.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Description：TODO
 * Create Time：2018/1/20 9:55
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
@Data
@ConfigurationProperties(prefix = "projectUrl")
@Component
public class ProjectUrlConfig {
    /*微信公众平台授权url*/
    public String wechatMpAuthorize;
    /*微信开放平台授权url*/
    public String wechatOpenAuthorize;
    /*点餐系统*/
    public String sell;
}
