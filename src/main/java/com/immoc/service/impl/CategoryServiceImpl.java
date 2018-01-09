package com.immoc.service.impl;

import com.immoc.dao.ProductCategoryDao;
import com.immoc.entity.ProductCategory;
import com.immoc.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description：TODO
 * Create Time：2018/1/9 14:19
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    ProductCategoryDao productCategoryDao;

    @Override
    public ProductCategory findOne(Integer categoryId) {
        return productCategoryDao.findOne(categoryId);
    }

    @Override
    public List<ProductCategory> findAll() {
        return productCategoryDao.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return productCategoryDao.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return productCategoryDao.save(productCategory);
    }
}
