package me.gyun.redis.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.gyun.redis.dto.DataDto;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

/**
 * created by jg 2021/04/07
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class RedisService {

    private final RedisTemplate<String, Object> redisTemplate;

    public void redisString() {
        ValueOperations<String, Object> operations = redisTemplate.opsForValue();
        operations.set("test", "test");
        String redis = (String)operations.get("star");
        log.info(redis);
    }

    public void redisObject() {
        ValueOperations<String, Object> operations = redisTemplate.opsForValue();
        DataDto dataDto = new DataDto();
        dataDto.setId(1L);
        dataDto.setName("Gyunny");
        operations.set("object", dataDto);
    }
}
