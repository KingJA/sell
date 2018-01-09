package com.immoc.dao;

import com.immoc.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Description：TODO
 * Create Time：2018/1/9 11:06
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public interface ProductCategoryDao extends JpaRepository<ProductCategory, Integer> {
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

}
