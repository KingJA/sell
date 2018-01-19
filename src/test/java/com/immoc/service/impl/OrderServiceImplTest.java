package com.immoc.service.impl;

import com.immoc.dto.OrderDTO;
import com.immoc.entity.OrderDetail;
import com.immoc.enums.OrderStatusEnum;
import com.immoc.enums.PayStatusEnum;
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
import java.util.Random;

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
    private String names []={"小龙","蒙多利亚","多里","菲儿","阿里","摩尔"};
    @Autowired
    private OrderService orderService;

    @Test
    public void create() {
//        for (int i = 0; i < 50; i++) {
//            OrderDTO orderDTO = new OrderDTO();
//            orderDTO.setBuyerName(names[new Random().nextInt(6)]);
//            orderDTO.setBuyerAddress("Jap");
//            orderDTO.setBuyerOpenid("ccc"+i);
//            orderDTO.setBuyerPhone(BUYER_PHONE);
//
//            List<OrderDetail> orderDetailList = new ArrayList<>();
//
//            OrderDetail orderDetail = new OrderDetail();
//            orderDetail.setProductId("1111111222");
//            orderDetail.setProductQuantity(1);
//            orderDetailList.add(orderDetail);
//
//            OrderDetail o2 = new OrderDetail();
//            o2.setProductId("123456");
//            o2.setProductQuantity(1);
//            orderDetailList.add(o2);
//
//            orderDTO.setOrderDetailList(orderDetailList);
//            OrderDTO result = orderService.create(orderDTO);
//        Assert.assertNotNull(result);
//        }

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(names[new Random().nextInt(6)]);
        orderDTO.setBuyerAddress("塘下镇塘中路");
        orderDTO.setBuyerOpenid("myopenid");
        orderDTO.setBuyerPhone(BUYER_PHONE);

        List<OrderDetail> orderDetailList = new ArrayList<>();

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProductId("1516084314695990163");
        orderDetail.setProductQuantity(1);
        orderDetailList.add(orderDetail);
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
        Assert.assertNotEquals(0, page.getTotalElements());
    }

    @Test
    public void list() {
        Page<OrderDTO> page = orderService.findList(new PageRequest(0, 3));
//        Assert.assertNotEquals(0, page.getTotalElements());
        Assert.assertTrue("【查询所有订单列表】", page.getTotalElements() > 0);
    }

    @Test
    public void cancel() {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.cancel(orderDTO);
        Assert.assertEquals(OrderStatusEnum.CANCEL.getCode(), result.getPayStatus());
    }

    @Test
    public void finish() {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.finish(orderDTO);
        Assert.assertEquals(OrderStatusEnum.FINISHED.getCode(), result.getPayStatus());
    }

    @Test
    public void paid() {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.paid(orderDTO);
        Assert.assertEquals(PayStatusEnum.SUCCESS.getCode(), result.getPayStatus());
    }
}