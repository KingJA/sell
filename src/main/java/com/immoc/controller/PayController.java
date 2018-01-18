package com.immoc.controller;

import com.immoc.dto.OrderDTO;
import com.immoc.enums.ResultEnum;
import com.immoc.exception.SellException;
import com.immoc.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Description：TODO
 * Create Time：2018/1/18 17:12
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
@Controller
@RequestMapping("/pay")
public class PayController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/create")
    public void create(@RequestParam("orderId")String orderId,@RequestParam("returnUrl")String returnUrl) {
        //1.查询订单
        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO == null) {
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        //.发起支付

    }
}
