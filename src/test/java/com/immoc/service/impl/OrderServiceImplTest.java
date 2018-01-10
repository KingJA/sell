package com.immoc.service.impl;

import com.immoc.dto.OrderDTO;
import com.immoc.entity.OrderDetail;
import com.immoc.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Description：TODO
 * Create Time：2018/1/10 16:13
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {
    private final String BUYER_OPENID = "abc123";
    private final String BUYER_PHONE = "18888888888";
    private final String ORDER_ID = "1515573761488868285";
    @Autowired
    private OrderService orderService;

    @Test
    public void create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("乔丹");
        orderDTO.setBuyerAddress("塘下朝阳路");
        orderDTO.setBuyerOpenid(BUYER_OPENID);
        orderDTO.setBuyerPhone(BUYER_PHONE);

        List<OrderDetail> orderDetailList = new ArrayList<>();

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProductId("1111111222");
        orderDetail.setProductQuantity(1);
        orderDetailList.add(orderDetail);

        OrderDetail o2 = new OrderDetail();
        o2.setProductId("123456");
        o2.setProductQuantity(1);
        orderDetailList.add(o2);

        orderDTO.setOrderDetailList(orderDetailList);
        OrderDTO result = orderService.create(orderDTO);
        Assert.assertNotNull(result);
    }

    @Test
    public void findOne() {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        Assert.assertNotNull(orderDTO);
    }

    @Test
    public void findList() {
        Page<OrderDTO> page = orderService.findList(BUYER_OPENID, new PageRequest(0, 3));
        Assert.assertNotEquals(0, page.getTotalPages());
        Assert.assertNotEquals(0, page.getTotalElements());
        Assert.assertNotEquals(0, page.getSize());
    }

    @Test
    public void cancel() {
    }

    @Test
    public void finish() {
    }

    @Test
    public void paid() {
    }
}