package com.immoc.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Description：TODO
 * Create Time：2018/1/9 14:30
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
@Entity
@Data
public class SellerInfo {
    @Id
    private String id;
    /*用户名*/
    private String username;
    /*密码*/
    private String password;
    /*openid*/
    private String openid;
}
