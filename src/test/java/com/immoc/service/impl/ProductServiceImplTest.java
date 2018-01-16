package com.immoc.service.impl;

import com.immoc.entity.ProductInfo;
import com.immoc.enums.ProductInfoEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

/**
 * Description：TODO
 * Create Time：2018/1/9 15:46
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {
    @Autowired
    private ProductServiceImpl productService;

    @Test
    public void findOne() {
        ProductInfo result = productService.findOne("1111111222");
        Assert.assertEquals("1111111222",result.getProductId());
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> result = productService.findUpAll();
        Assert.assertNotEquals(0, result.size());
    }

    @Test
    public void findAll() {
        PageRequest pageRequest = new PageRequest(0, 2);
        Page<ProductInfo> page = productService.findAll(pageRequest);
        System.out.println(page.getTotalElements());
    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123456");
        productInfo.setProductName("乔丹5代");
        productInfo.setProductPrice(new BigDecimal(500.0));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("珍藏版");
        productInfo.setProductIcon("http://xxxx.jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(2);
        ProductInfo result = productService.save(productInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void onSale() {
        ProductInfo productInfo = productService.onSale("1111111222");
        Assert.assertTrue(productInfo.getProductStatus()== ProductInfoEnum.UP.getCode());

    }
    @Test
    public void offSale() {
        ProductInfo productInfo = productService.offSale("1111111222");
        Assert.assertTrue(productInfo.getProductStatus()== ProductInfoEnum.DOWN.getCode());
    }
}