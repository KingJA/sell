package com.immoc.viewobject;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Description：TODO
 * Create Time：2018/1/9 16:34
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
@Data
public class ProductInfoVO {
    private String id;
    private String name;
    private BigDecimal price;
    private String description;
    private String icon;
}
