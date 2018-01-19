package com.immoc.service;

import com.immoc.entity.SellerInfo;

/**
 * Description：TODO
 * Create Time：2018/1/19 15:00
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public interface SellerService {
    SellerInfo findSellerInfoByOpenid(String openid);
}
