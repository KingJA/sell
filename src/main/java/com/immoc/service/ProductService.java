package com.immoc.service;

import com.immoc.dto.CartDTO;
import com.immoc.entity.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Description：TODO
 * Create Time：2018/1/9 15:35
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public interface ProductService {
    ProductInfo findOne(String productId);

    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    void increaseStock(List<CartDTO> cartDTOList);

    void decreaseStock(List<CartDTO> cartDTOList);

    /*上架*/
    ProductInfo onSale(String productId);

    /*下架*/
    ProductInfo offSale(String productId);

}
