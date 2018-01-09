package com.immoc.dao;

import com.immoc.entity.ProductInfo;
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
 * Create Time：2018/1/9 15:18
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoDaoTest {
    @Autowired
    private ProductInfoDao productInfoDao;

    @Test
    public void add() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("1111111222");
        productInfo.setProductName("科比二代");
        productInfo.setProductPrice(new BigDecimal(200.5));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("珍藏版");
        productInfo.setProductIcon("http://xxxx.jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(2);
        ProductInfo result = productInfoDao.save(productInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByProductStatus() {
        List<ProductInfo> result = productInfoDao.findByProductStatus(0);
        Assert.assertNotEquals(0, result.size());
    }
}