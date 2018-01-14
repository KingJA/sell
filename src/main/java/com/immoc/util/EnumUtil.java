package com.immoc.util;

import com.immoc.enums.CodeEnum;

/**
 * Description:TODO
 * Create Time:2018/1/13 22:08
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class EnumUtil{
    public static<T extends CodeEnum>  T getByCode(Integer code, Class<T> enumClass) {
        for (T t : enumClass.getEnumConstants()) {
            if (code.equals(t.getCode())) {
                return t;
            }
        }
        return null;
    }
}
