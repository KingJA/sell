package com.immoc.dao;

import com.immoc.entity.SellerInfo;
import com.immoc.util.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Description：TODO
 * Create Time：2018/1/19 14:50
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SellerInfoDaoTest {
    @Autowired
    private SellerInfoDao sellerInfoDao;

    @Test
    public void findByOpenid() {
        SellerInfo sellerInfo = sellerInfoDao.findByOpenid("oIggDwmZFf_MVZ3zc58PhJa-i1YM");
        Assert.assertEquals("oIggDwmZFf_MVZ3zc58PhJa-i1YM",sellerInfo.getOpenid());
    }

    @Test
    public void add() {
        SellerInfo sellerInfo = new SellerInfo();
        sellerInfo.setId(KeyUtil.getKey());
        sellerInfo.setOpenid("oIggDwmZFf_MVZ3zc58PhJa-i1YM");
        sellerInfo.setPassword("password");
        sellerInfo.setUsername("KingJA");
        SellerInfo result = sellerInfoDao.save(sellerInfo);
        Assert.assertNotNull(result);
    }
}