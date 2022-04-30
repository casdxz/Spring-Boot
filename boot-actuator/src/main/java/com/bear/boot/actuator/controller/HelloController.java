package com.bear.boot.actuator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: bear
 * @create: 2022-04-15 08:57
 **/
@RestController
public class HelloController {

    @GetMapping("hello")
    public String getHello() {
        return "hello world";
    }
}
