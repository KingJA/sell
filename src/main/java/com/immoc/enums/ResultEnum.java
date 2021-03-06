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
    SUCCESS(0, "成功"),
    PARAM_ERROR(1, "参数不正确"),
    JSON_ERROR(2, "json格式错误"),
    PRODUCT_NOT_EXIST(10, "商品部存在"),
    PRODUCT_STOCK_ERROR(11, "商品库存不够"),
    ORDER_NOT_EXIST(12, "订单不存在"),
    ORDER_DETAIL_NOT_EXIST(13, "订单详情不存在"),
    ORDER_STATUS_ERROR(14, "订单状态异常"),
    ORDER_UPDATE_FAIL(15, "订单更新异常"),
    ORDER_DETAIL_EMPTY(16, "订单商品为空"),
    ORDER_ORDER_PAY_ERROR(17, "订单支付状态异常"),
    CART_EMPTY(18, "购物车不能为空"),
    ORDER_OWNER_ERROR(18, "查询openid不一致"),
    SUCCESS_CANCEL(22, "取消订单成功"),
    SUCCESS_FINISH(23, "完结订单成功"),
    PRODUCT_STATUS_ERROR(24, "商品状态异常"),
    SUCCESS_ONSALE(26, "商品上架成功"),
    WEICHAT_ERROR(28, "微信公账号方面错误"),
    SUCCESS_OFFSALE(27, "商品下架成功"),
    LOGIN_ERROR(28, "账号登录失败"),
    SUCCESS_LOGOUT(29, "账号退出成功"),
    ;
    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
