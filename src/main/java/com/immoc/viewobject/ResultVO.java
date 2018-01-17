package com.immoc.viewobject;

import lombok.Data;

import java.io.Serializable;

/**
 * Description：http请求返回给前端的最外层对象
 * Create Time：2018/1/9 16:14
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
@Data
public class ResultVO<T> implements Serializable{
    private static final long serialVersionUID = -1830327244797532141L;
    private Integer code;
    private String msg;
    private T data;
}
