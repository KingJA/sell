package com.immoc.converter;

import com.immoc.dto.OrderDTO;
import com.immoc.entity.OrderMaster;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Description：TODO
 * Create Time：2018/1/10 17:17
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class OrderMaster2OrderDTO {

    public static OrderDTO convert(OrderMaster master) {
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(master, orderDTO);
        return orderDTO;
    }

    public static List<OrderDTO> convert(List<OrderMaster> masters) {
        return masters.stream().map(e -> convert(e)).collect(Collectors.toList());
    }
}
