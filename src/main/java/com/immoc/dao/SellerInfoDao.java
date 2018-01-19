package com.immoc.dao;

import com.immoc.entity.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Description：TODO
 * Create Time：2018/1/10 14:26
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public interface SellerInfoDao extends JpaRepository<SellerInfo, Integer> {
    SellerInfo findByOpenid(String openid);
}
