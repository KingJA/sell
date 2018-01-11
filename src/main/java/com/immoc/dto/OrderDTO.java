package com.immoc.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.immoc.entity.OrderDetail;
import com.immoc.enums.OrderStatusEnum;
import com.immoc.enums.PayStatusEnum;
import com.immoc.util.serializer.Date2LongSerializer;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Description：TODO
 * Create Time：2018/1/10 15:01
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {
    private String orderId;
    /*买家名字*/
    private String buyerName;
    /*买家电话*/
    private String buyerPhone;
    /*买家地址*/
    private String buyerAddress;
    /*买家微信openid*/
    private String buyerOpenid;
    /*订单总金额*/
    private BigDecimal orderAmount;
    /*订单状态, 默认为0新下单*/
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();
    /*支付状态, 默认0未支付*/
    private Integer payStatus = PayStatusEnum.WAIT.getCode();
    /*创建时间*/
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;
    /*修改时间*/
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    private List<OrderDetail> orderDetailList;
}
