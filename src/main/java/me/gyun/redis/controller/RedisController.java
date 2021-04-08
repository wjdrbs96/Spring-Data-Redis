package me.gyun.redis.controller;

import lombok.RequiredArgsConstructor;
import me.gyun.redis.service.RedisService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * created by jg 2021/04/07
 */
@RequiredArgsConstructor
@RestController
public class RedisController {

    private final RedisService redisService;
    private final HttpSession session;

    @GetMapping("/")
    public String test(HttpSession httpSession) {
        return "test";
    }
}
