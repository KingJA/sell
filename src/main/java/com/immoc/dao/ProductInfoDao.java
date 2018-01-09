package com.immoc.dao;

import com.immoc.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Description：TODO
 * Create Time：2018/1/9 14:35
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public interface ProductInfoDao extends JpaRepository<ProductInfo, String> {
    List<ProductInfo> findByProductStatus(Integer productStatus);
}
