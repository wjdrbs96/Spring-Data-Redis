package me.gyun.redis.controller;

import lombok.RequiredArgsConstructor;
import me.gyun.redis.service.RedisService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by jg 2021/04/07
 */
@RequiredArgsConstructor
@RestController
public class RedisController {

    private final RedisService redisService;

    @GetMapping("/")
    public String test() {
        redisService.redisString();
        return "test";
    }

    @GetMapping("/redis")
    public String redis() {
        redisService.redisObject();
        return "test";
    }
}
