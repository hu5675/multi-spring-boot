package com.mars.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.HashMap;
import java.util.Map;

//使 @Cacheable 注解有效 1： 在Application中加注解 @EnableCaching   2： 放开下面2行注释
//@Configuration
//@EnableCaching
public class CacheConfig {
    @Bean
    @Autowired
    public CacheManager cacheManager(RedisTemplate<Object, Object> redisTemplate) {
        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
//        Map<String, Long> expires = new HashMap<>();
//        expires.put("cache.day", new Long(24 * 60 * 60));
//        cacheManager.setExpires(expires);
        return cacheManager;
    }
}
