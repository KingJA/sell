package com.immoc.converter;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.immoc.dto.OrderDTO;
import com.immoc.entity.OrderDetail;
import com.immoc.enums.ResultEnum;
import com.immoc.exception.SellException;
import com.immoc.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * Description：TODO
 * Create Time：2018/1/11 13:30
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
@Slf4j
public class OrderForm2OrderDTO {
    public static OrderDTO convert(OrderForm orderForm) {
        Gson gson = new Gson();
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getName());
        orderDTO.setBuyerAddress(orderForm.getName());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetails;
        try {
            orderDetails = gson.fromJson(orderForm.getItems(), new TypeToken<List<OrderDetail>>() {
            }.getType());
        } catch (JsonSyntaxException e) {
            log.error("【对象转换】错误，jsonString={}", orderForm.getItems());
            throw new SellException(ResultEnum.JSON_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetails);
        return orderDTO;

    }
}
