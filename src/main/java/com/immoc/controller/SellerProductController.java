package com.immoc.controller;

import com.immoc.entity.ProductCategory;
import com.immoc.entity.ProductInfo;
import com.immoc.enums.ResultEnum;
import com.immoc.form.ProductForm;
import com.immoc.service.CategoryService;
import com.immoc.service.ProductService;
import com.immoc.util.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * Description:TODO
 * Create Time:2018/1/13 18:06
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
@Controller
@RequestMapping("/seller/product")
@Slf4j
public class SellerProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "10") Integer size,
                             Map<String, Object> map) {
        Page<ProductInfo> productInfoPage = productService.findAll(new PageRequest(page - 1, size));
        map.put("productInfoPage", productInfoPage);
        map.put("currentPage", page);
        map.put("size", size);
        return new ModelAndView("product/list", map);
    }

    @GetMapping("/on_sale")
    public ModelAndView onSale(@RequestParam("productId") String productId, Map<String, Object> map) {
        try {
            productService.onSale(productId);
        } catch (Exception e) {
            log.error("【商品上架】发生异常{}", e);
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/order/list");
            return new ModelAndView("common/error", map);
        }
        map.put("msg", ResultEnum.SUCCESS_ONSALE.getMsg());
        map.put("url", "/sell/seller/product/list");
        return new ModelAndView("common/success", map);
    }


    @GetMapping("/off_sale")
    public ModelAndView offSale(@RequestParam("productId") String productId, Map<String, Object> map) {
        try {
            productService.offSale(productId);
        } catch (Exception e) {
            log.error("【商品下架】发生异常{}", e);
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/order/list");
            return new ModelAndView("common/error", map);
        }
        map.put("msg", ResultEnum.SUCCESS_OFFSALE.getMsg());
        map.put("url", "/sell/seller/product/list");
        return new ModelAndView("common/success", map);
    }

    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "productId", required = false) String productId,
                              Map<String, Object> map) {
        if (!StringUtils.isEmpty(productId)) {
            ProductInfo productInfo = productService.findOne(productId);
            map.put("productInfo", productInfo);
        }
        List<ProductCategory> categories = categoryService.findAll();
        map.put("categories", categories);
        return new ModelAndView("product/index", map);
    }

    @PostMapping("/save")
    public ModelAndView save(@Valid ProductForm productForm, BindingResult bindingResult, Map<String, Object> map) {
        if (bindingResult.hasFieldErrors()) {
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/sell/seller/product/index?productId=" + productForm.getProductId());
            return new ModelAndView("common/error", map);
        }
        ProductInfo productInfo = new ProductInfo();
        try {
            if (!StringUtils.isEmpty(productForm.getProductId())) {
                productInfo = productService.findOne(productForm.getProductId());
            } else {
                productForm.setProductId(KeyUtil.getKey());
            }
            BeanUtils.copyProperties(productForm, productInfo);
            productService.save(productInfo);
        } catch (Exception e) {
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/product/?productId=" + productForm.getProductId());
            return new ModelAndView("common/error", map);
        }
        map.put("url", "/sell/seller/product/list");
        return new ModelAndView("common/success", map);
    }
}
