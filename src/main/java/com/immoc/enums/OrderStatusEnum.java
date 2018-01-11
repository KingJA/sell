package com.immoc.enums;

import lombok.Getter;

/**
 * Description：TODO
 * Create Time：2018/1/10 13:40
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
@Getter
public enum OrderStatusEnum {
    NEW(0,"新订单"),
    FINISHED(1,"订单完成"),
    CANCEL(2,"订单取消");

    private Integer code;
    private String msg;

    OrderStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
