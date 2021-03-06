package com.immoc.viewobject;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Description：TODO
 * Create Time：2018/1/9 16:34
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
@Data
public class ProductInfoVO implements Serializable {
    private static final long serialVersionUID = -8489869172832488061L;
    @JsonProperty("id")
    private String productId;

    @JsonProperty("name")
    private String productName;

    @JsonProperty("price")
    private BigDecimal productPrice;

    @JsonProperty("description")
    private String productDescription;

    @JsonProperty("icon")
    private String productIcon;
}
