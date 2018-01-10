package com.immoc.service.impl;

import com.immoc.converter.OrderMaster2OrderDTO;
import com.immoc.dao.OrderDetailDao;
import com.immoc.dao.OrderMasterDao;
import com.immoc.dto.CartDTO;
import com.immoc.dto.OrderDTO;
import com.immoc.entity.OrderDetail;
import com.immoc.entity.OrderMaster;
import com.immoc.entity.ProductInfo;
import com.immoc.enums.ResultEnum;
import com.immoc.exception.SellException;
import com.immoc.service.OrderService;
import com.immoc.service.ProductService;
import com.immoc.util.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Description：TODO
 * Create Time：2018/1/10 15:10
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderDetailDao orderDetailDao;
    @Autowired
    private OrderMasterDao orderMasterDao;

    @Override
    @Transactional
    public OrderDTO create(OrderDTO orderDTO) {
        String orderId = KeyUtil.getKey();
        //1.查询商品
        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);
        for (OrderDetail orderDetail : orderDTO.getOrderDetailList()) {
            ProductInfo productInfo = productService.findOne(orderDetail.getProductId());
            if (productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            //2.计算订单总价
            orderAmount = productInfo.getProductPrice().multiply(new BigDecimal(orderDetail.getProductQuantity())).add(orderAmount);
            //订单详情写入库
            BeanUtils.copyProperties(productInfo, orderDetail);
            orderDetail.setDetailId(KeyUtil.getKey());
            orderDetail.setOrderId(orderId);
            orderDetailDao.save(orderDetail);

        }
        //3.写入订单数据库(OrderMaster,OrderDetail)
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderId(orderId);
        orderMaster.setOrderAmount(orderAmount);
        orderMasterDao.save(orderMaster);
        //4.扣库存
        List<CartDTO> cartDTOList = orderDTO.getOrderDetailList().stream().map(e -> new CartDTO(e.getProductId(), e.getProductQuantity())).collect(Collectors.toList());
        productService.decreaseStock(cartDTOList);
        return orderDTO;
    }

    @Override
    public OrderDTO findOne(String orderId) {
        OrderMaster orderMaster = orderMasterDao.findOne(orderId);
        if (orderMaster == null) {
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        List<OrderDetail> orderDetailList = orderDetailDao.findByOrderId(orderId);
        if (CollectionUtils.isEmpty(orderDetailList)) {
            throw new SellException(ResultEnum.ORDER_DETAIL_NOT_EXIST);
        }
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster, orderDTO);
        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }

    @Override
    public Page<OrderDTO> findList(String buyerOpenid, Pageable pageable) {
        Page<OrderMaster> orderMasterPage = orderMasterDao.findByBuyerOpenid(buyerOpenid, pageable);
        List<OrderDTO> orderDTOs = OrderMaster2OrderDTO.convert(orderMasterPage.getContent());
        return new PageImpl<OrderDTO>(orderDTOs, pageable, orderMasterPage.getTotalElements());
    }

    @Override
    public OrderDTO cancel(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO finish(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO paid(OrderDTO orderDTO) {
        return null;
    }
}
