package com.immoc.dto;

import lombok.Data;

/**
 * Description：TODO
 * Create Time：2018/1/10 15:58
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
@Data
public class CartDTO {
    private String productId;
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
