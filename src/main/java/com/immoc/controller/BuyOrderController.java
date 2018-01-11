package com.immoc.controller;

import com.immoc.converter.OrderForm2OrderDTO;
import com.immoc.dto.OrderDTO;
import com.immoc.enums.ResultEnum;
import com.immoc.exception.SellException;
import com.immoc.form.OrderForm;
import com.immoc.service.BuyerService;
import com.immoc.service.OrderService;
import com.immoc.util.ResultVoUtil;
import com.immoc.viewobject.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description：TODO
 * Create Time：2018/1/11 13:12
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyOrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private BuyerService buyerService;
    //创建订单

    @PostMapping("/create")
    public ResultVO<Map<String, String>> create(@Valid OrderForm orderForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【创建订单】参数不正确，orderForm={}", orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO orderDTO = OrderForm2OrderDTO.convert(orderForm);

        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("【创建订单】购物车不能为空");
            throw new SellException(ResultEnum.CART_EMPTY);
        }
        OrderDTO createResult = orderService.create(orderDTO);
        Map<String, String> map = new HashMap<>();
        map.put("orderId", createResult.getOrderId());
        return ResultVoUtil.success(map);

    }

    //订单列表
    @GetMapping("list")
    public ResultVO<List<OrderDTO>> list(@RequestParam("openid") String openid, @RequestParam(value = "page",
            defaultValue = "0") Integer page, @RequestParam(value = "size", defaultValue = "10") Integer size) {
        if (StringUtils.isEmpty(openid)) {
            log.error("【查询订单列表】openid不能为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }

        Page<OrderDTO> result = orderService.findList(openid, new PageRequest(page, size));
        return ResultVoUtil.success(result.getContent());
    }

    //订单详情
    @GetMapping("detail")
    public ResultVO<OrderDTO> detail(@RequestParam("openid") String openid, @RequestParam("orderId") String orderId) {
        return ResultVoUtil.success(buyerService.findOrderOne(openid, orderId));
    }
    //取消订单

    @PostMapping("/cancel")
    public ResultVO cancel(@RequestParam("openid") String openid, @RequestParam("orderId") String orderId) {
        buyerService.cancelOrder(openid, orderId);
        return ResultVoUtil.success();
    }
}
