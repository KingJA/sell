package com.immoc.exception;

import com.immoc.enums.ResultEnum;
import lombok.Getter;

/**
 * Description：TODO
 * Create Time：2018/1/10 15:26
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
@Getter
public class SellException extends RuntimeException {
    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public SellException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }
}
