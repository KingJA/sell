package com.immoc.exception;

import com.immoc.enums.ResultEnum;

/**
 * Description：TODO
 * Create Time：2018/1/10 15:26
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class SellException extends RuntimeException {
    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }
}
