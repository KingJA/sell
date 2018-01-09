package com.immoc.dao;

import com.immoc.entity.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

/**
 * Description：TODO
 * Create Time：2018/1/9 11:07
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryDaoTest {
    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Test
    @Transactional
    public void add() {
        ProductCategory productCategory = new ProductCategory("游戏机", 4);
        ProductCategory result = productCategoryDao.save(productCategory);
        Assert.assertNotNull(result);
    }

    @Test
    public void update() {
        ProductCategory productCategory = new ProductCategory("女士手表", 2);
        productCategory.setCategoryId(2);
        productCategoryDao.save(productCategory);
    }

    @Test
    public void query() {
        ProductCategory productCategory = productCategoryDao.findOne(1);
        System.out.println(productCategory.toString());
    }

    @Test
    public void delete() {
        productCategoryDao.delete(2);
    }

    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategory> result = productCategoryDao.findByCategoryTypeIn(Arrays.asList(1, 2, 3));
        Assert.assertNotEquals(0,result.size());
    }
}