package com.immoc.dao;

import com.immoc.entity.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Description：TODO
 * Create Time：2018/1/10 14:19
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public interface OrderMasterDao extends JpaRepository<OrderMaster, String> {
    Page<OrderMaster> findByBuyerOpenid(String openid,Pageable pageable);
}
