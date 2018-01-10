package com.immoc.dao;

import com.immoc.entity.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

/**
 * Description：TODO
 * Create Time：2018/1/10 14:45
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailDaoTest {
    @Autowired
    private OrderDetailDao orderDetailDao;

    @Test
    public void add() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderId("1234566");
        orderDetail.setDetailId("1212126");
        orderDetail.setProductId("1234566");
        orderDetail.setProductIcon("aaa.jpg");
        orderDetail.setProductName("三文鱼");
        orderDetail.setProductPrice(new BigDecimal(88.5));
        orderDetail.setProductQuantity(110);
        OrderDetail result = orderDetailDao.save(orderDetail);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByOrderId() {
        List<OrderDetail> result = orderDetailDao.findByOrderId("123456");
        Assert.assertNotEquals(0,result.size());
    }
}