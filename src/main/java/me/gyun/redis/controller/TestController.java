package me.gyun.redis.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by jg 2021/04/07
 */
@RestController
public class TestController {

    @GetMapping("/")
    public String test() {
        return "test";
    }
}
