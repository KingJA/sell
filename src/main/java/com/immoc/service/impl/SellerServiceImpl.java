package com.immoc.service.impl;

import com.immoc.dao.SellerInfoDao;
import com.immoc.entity.SellerInfo;
import com.immoc.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description：TODO
 * Create Time：2018/1/19 15:02
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
@Service
public class SellerServiceImpl implements SellerService {
    @Autowired
    private SellerInfoDao sellerInfoDao;

    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {
        return sellerInfoDao.findByOpenid(openid);
    }
}
