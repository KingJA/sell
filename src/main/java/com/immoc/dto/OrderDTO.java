package com.immoc.dto;

import com.immoc.entity.OrderDetail;
import com.immoc.enums.OrderStatusEnum;
import com.immoc.enums.PayStatusEnum;
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
    private Date createTime;
    /*修改时间*/
    private Date updateTime;

    private List<OrderDetail> orderDetailList;
}
