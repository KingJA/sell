package com.immoc.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Description：TODO
 * Create Time：2018/1/19 10:30
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class JsonUtil {

    public static String toJson(Object object) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }
}
