package com.lichuachua.blog.blogserver.util;

/**
 * @author meteor
 * Redis键生成器
 */
public class RedisKeyUtil {

    public static String buildKey(String template, String ...args) {
        return String.format(template, args);
    }
}