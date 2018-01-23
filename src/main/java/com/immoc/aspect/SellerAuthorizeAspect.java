package com.immoc.aspect;

import com.immoc.constant.CookieConstant;
import com.immoc.constant.RedisConstant;
import com.immoc.exception.SellerAuthorizeException;
import com.immoc.util.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Description：TODO
 * Create Time：2018/1/20 11:11
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
@Aspect
@Component
@Slf4j
public class SellerAuthorizeAspect {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Pointcut("execution(public * com.immoc.controller.Seller*.*(..))&& !execution(public * com.immoc.controller" +
            ".SellerUserController.*(..))")
    public void verify(){}

    @Before("verify()")
    public void doVerify() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
        //查询cookie
        if (cookie == null) {
            log.error("【登录校验】Cookie中查询不到token");
            throw new SellerAuthorizeException();
        }
        //从cookie中查询token
        String token = redisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_PREFIX, cookie.getValue()));
        if (StringUtils.isEmpty(token)) {
            log.error("【登录校验】Redis中查询不到token");
            throw new SellerAuthorizeException();
        }
    }

}
