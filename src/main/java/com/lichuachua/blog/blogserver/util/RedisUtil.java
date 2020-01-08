package com.lichuachua.blog.blogserver.util;
import com.lichuachua.blog.common.util.JsonUtil;
import org.springframework.data.redis.core.StringRedisTemplate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RedisUtil {

    public static boolean exists(StringRedisTemplate redisTemplate, String key) {
        return redisTemplate.hasKey(key);
    }

    public static<T> void set (StringRedisTemplate redisTemplate, String key, T  value) {
        redisTemplate.opsForValue().set(key, JsonUtil.toJson(value));
    }

    public static<T> T get (StringRedisTemplate redisTemplate, String key, Class<T> clazz) {
        String value = redisTemplate.opsForValue().get(key);
        if (null != value) {
            return JsonUtil.toObject(value, clazz);
        }
        return null;
    }

    public static void del(StringRedisTemplate redisTemplate, String key) {
        redisTemplate.delete(key
        );
    }

    public static<T> void rPush(StringRedisTemplate redisTemplate, String key, T value) {
        redisTemplate.opsForList().rightPush(key, JsonUtil.toJson(value));
    }

    public static <T> List<T> getList(StringRedisTemplate redisTemplate, String key, Class<T> clazz) {
        List<T> list = new ArrayList<>();
        long size = redisTemplate.opsForList().size(key);
        List<String> records = redisTemplate.opsForList()
                .range(key, 0,  size -  1);
        if (null != records) {
            list = records.stream()
                    .map(record -> JsonUtil.toObject(record, clazz))
                    .collect(Collectors.toList());
        }
        return list;
    }
}
