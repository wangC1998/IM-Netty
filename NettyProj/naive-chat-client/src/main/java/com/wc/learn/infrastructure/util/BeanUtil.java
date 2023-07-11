package com.wc.learn.infrastructure.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BeanUtil {
    private static Map<String, Object> cacheMap = new ConcurrentHashMap<>();

    public static void addBean(String name, Object bean) {
        cacheMap.put(name, bean);
    }

    public static <T> T getBean(String name, Class<T> t) {
        return (T) cacheMap.get(name);
    }
}
