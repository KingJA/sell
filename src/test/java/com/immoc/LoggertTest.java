package com.immoc;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Description：TODO
 * Create Time：2018/1/8 16:11
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggertTest {

    @Test
    public void test1() {
        String name = "immoc";
        String password = "immoc";
        log.debug("debug=");
        log.info("info=");
        log.error("error=");
        log.info("name:{},password:{}", name, password);
    }
}
