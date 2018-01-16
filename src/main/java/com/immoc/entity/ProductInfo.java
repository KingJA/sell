package com.immoc.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.immoc.enums.ProductInfoEnum;
import com.immoc.util.EnumUtil;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Description：TODO
 * Create Time：2018/1/9 14:30
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
@Entity
@Data
public class ProductInfo {
    @Id
    private String productId;
    /*商品名称*/
    private String productName;
    /*单价*/
    private BigDecimal productPrice;
    /*库存*/
    private Integer productStock;
    /*描述*/
    private String productDescription;
    /*小图*/
    private String productIcon;
    /*商品状态,0正常1下架*/
    private int productStatus=ProductInfoEnum.UP.getCode();
    /*类目编号*/
    private Integer categoryType;
    /*创建时间*/
    private Date createTime;
    /*修改时间*/
    private Date updateTime;
    @JsonIgnore
    public ProductInfoEnum getProductInfoEnum() {
        return EnumUtil.getByCode(productStatus, ProductInfoEnum.class);
    }
}
