package com.immoc.util;

import java.util.Random;

/**
 * Description：TODO
 * Create Time：2018/1/10 15:40
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class KeyUtil {

    public static synchronized String getKey() {
        Integer rundomNum = new Random().nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(rundomNum);
    }
}
