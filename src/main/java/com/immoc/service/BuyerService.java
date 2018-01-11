package com.immoc.service;

import com.immoc.dto.OrderDTO;

/**
 * Description：TODO
 * Create Time：2018/1/11 15:41
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public interface BuyerService {
    OrderDTO findOrderOne(String openid, String orderId);

    OrderDTO cancelOrder(String openid, String orderId);
}
