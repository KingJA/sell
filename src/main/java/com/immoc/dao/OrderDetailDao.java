package com.immoc.dao;

import com.immoc.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Description：TODO
 * Create Time：2018/1/10 14:26
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public interface OrderDetailDao extends JpaRepository<OrderDetail,String> {
    List<OrderDetail> findByOrderId(String orderId);
}
