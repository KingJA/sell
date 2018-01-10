package com.immoc.enums;

import lombok.Getter;

/**
 * Description：TODO
 * Create Time：2018/1/10 13:44
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
@Getter
public enum  PayStatusEnum {
    WAIT(0,"未支付"),
    SUCCESS(1,"支付成功");
    private Integer code;
    private String msg;

    PayStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
