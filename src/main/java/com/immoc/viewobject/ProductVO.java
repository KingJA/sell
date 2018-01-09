package com.immoc.viewobject;

import lombok.Data;

import java.util.List;

/**
 * Description：TODO
 * Create Time：2018/1/9 16:31
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
@Data
public class ProductVO {
    private String name;
    private Integer type;
    private List<ProductInfoVO> foods;
}
