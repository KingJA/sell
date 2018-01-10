package com.immoc.controller;

import com.immoc.entity.ProductCategory;
import com.immoc.entity.ProductInfo;
import com.immoc.service.CategoryService;
import com.immoc.service.ProductService;
import com.immoc.util.ResultVoUtil;
import com.immoc.viewobject.ProductInfoVO;
import com.immoc.viewobject.ProductVO;
import com.immoc.viewobject.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Description：TODO
 * Create Time：2018/1/9 16:15
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO list() {
        //  查询所有上架商品
        List<ProductInfo> productInfoList = productService.findUpAll();
        //  查询类目(一次性查询)
        List<Integer> categoryTypeList = productInfoList.stream().map(e -> e.getCategoryType()).collect(Collectors.toList());
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);
        //  数据拼装
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setName(productCategory.getCategoryName());
            productVO.setType(productCategory.getCategoryType());
            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setFoods(productInfoVOList);
            productVOList.add(productVO);
        }
        return ResultVoUtil.success(productVOList);
    }
}
