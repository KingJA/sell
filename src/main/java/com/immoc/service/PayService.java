package com.immoc.service;

import com.immoc.dto.OrderDTO;
import com.lly835.bestpay.model.PayResponse;

/**
 * Description：TODO
 * Create Time：2018/1/18 17:15
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public interface PayService {
    PayResponse create(OrderDTO orderDTO);
}
