package com.immoc.enums;

import lombok.Getter;

/**
 * Description：TODO
 * Create Time：2018/1/10 15:25
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
@Getter
public enum ResultEnum {
    PRODUCT_NOT_EXIST(10, "商品部存在"),
    PRODUCT_STOCK_ERROR(11, "商品库存不够"),
    ORDER_NOT_EXIST(12, "订单不存在"),
    ORDER_DETAIL_NOT_EXIST(13, "订单详情不存在");
    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
