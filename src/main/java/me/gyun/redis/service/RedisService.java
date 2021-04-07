package me.gyun.redis.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

/**
 * created by jg 2021/04/07
 */
@RequiredArgsConstructor
@Service
public class RedisService {

    private final RedisTemplate<String, Object> redisTemplate;

    public void redisService() {
        ValueOperations<String, Object> operations = redisTemplate.opsForValue();
        operations.set("redis", "redis");
        String redis = (String)operations.get("redis");
        System.out.println(redis);
    }
}
