package com.immoc.viewobject;

import lombok.Data;

/**
 * Description：http请求返回给前端的最外层对象
 * Create Time：2018/1/9 16:14
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
@Data
public class ResultView<T> {
    private Integer code;
    private String msg;
    private T data;
}
