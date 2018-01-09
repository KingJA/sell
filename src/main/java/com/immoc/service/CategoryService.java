package com.immoc.service;

import com.immoc.entity.ProductCategory;

import java.util.List;

/**
 * Description：TODO
 * Create Time：2018/1/9 14:17
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public interface CategoryService {
    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
