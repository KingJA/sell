package com.immoc.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Description：TODO
 * Create Time：2018/1/11 13:14
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
@Data
public class OrderForm {
    @NotEmpty(message = "姓名必填")
    private String name;
    @NotEmpty(message = "手机号码必填")
    private String phone;
    @NotEmpty(message = "地址必填")
    private String address;
    @NotEmpty(message = "openid不能为空")
    private String openid;
    @NotEmpty(message = "购物车不能为空")
    private String items;

}
