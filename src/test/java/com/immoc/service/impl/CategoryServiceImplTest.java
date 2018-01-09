package com.immoc.service.impl;

import com.immoc.entity.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * Description：TODO
 * Create Time：2018/1/9 14:21
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {
    @Autowired
    CategoryServiceImpl categoryService;

    @Test
    public void findOne() throws Exception {
        ProductCategory result = categoryService.findOne(1);
        Assert.assertNotNull(result);
    }

    @Test
    public void findAll() throws Exception {
        List<ProductCategory> result = categoryService.findAll();
        Assert.assertNotEquals(0, result);
    }

    @Test
    public void findByCategoryTypeIn() throws Exception {
        List<ProductCategory> result = categoryService.findByCategoryTypeIn(Arrays.asList(1, 2, 3));
        Assert.assertNotEquals(0, result);
    }

    @Test
    public void save() throws Exception {
        ProductCategory result = categoryService.save(new ProductCategory("娱乐", 5));
        Assert.assertNotNull(result);
    }

}