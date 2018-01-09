package com.immoc.enums;

import lombok.Getter;

/**
 * Description：TODO
 * Create Time：2018/1/9 15:43
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
@Getter
public enum ProductInfoEnum {
    UP(0, "上架"), DOWN(1, "下架");
    private Integer code;
    private String message;

    ProductInfoEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
