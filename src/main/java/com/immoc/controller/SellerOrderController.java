package com.immoc.controller;

import com.immoc.dto.OrderDTO;
import com.immoc.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

/**
 * Description:TODO
 * Create Time:2018/1/13 18:06
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
@Controller
@RequestMapping("/seller/order")
@Slf4j
public class SellerOrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value =
            "size", defaultValue = "10") Integer size, Map<String, Object> map) {
        log.error("page={},size={}", page, size);
        Page<OrderDTO> orderDTOPage = orderService.findList(new PageRequest(page - 1, size));
        map.put("orderDTOPage", orderDTOPage);
        return new ModelAndView("order/list", map);

    }

}
