package com.immoc.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.math.BigDecimal;

/**
 * Description：TODO
 * Create Time：2018/1/9 14:30
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
@Data
public class ProductForm {
    private String productId;
    /*商品名称*/
    @NotEmpty(message = "商品名称必填")
    private String productName;
    /*单价*/
    private BigDecimal productPrice;
    /*库存*/
    private Integer productStock;
    /*描述*/
    @NotEmpty(message = "描述必填")
    private String productDescription;
    /*小图*/
    @NotEmpty(message = "请添加图片")
    private String productIcon;
    /*类目编号*/
    private Integer categoryType;
}
