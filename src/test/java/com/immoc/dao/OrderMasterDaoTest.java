package com.immoc.dao;

import com.immoc.entity.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

/**
 * Description：TODO
 * Create Time：2018/1/10 14:28
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterDaoTest {
    @Autowired
    private OrderMasterDao orderMasterDao;
    private final String OPENID = "abc123";

    @Test
    public void add() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("123456");
        orderMaster.setBuyerName("科比");
        orderMaster.setBuyerPhone("18888888888");
        orderMaster.setBuyerAddress("美国洛杉矶");
        orderMaster.setBuyerOpenid("abc123");
        orderMaster.setOrderAmount(new BigDecimal(100.5));
        orderMasterDao.save(orderMaster);
    }

    @Test
    public void findByBuyerOrOrderId() {
        PageRequest pageRequest = new PageRequest(0, 2);
        Page<OrderMaster> result = orderMasterDao.findByBuyerOpenid(OPENID, pageRequest);
        Assert.assertNotEquals(0,result.getTotalElements());
    }
}