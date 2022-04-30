package com.bear.boot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: bear
 * @create: 2022-04-08 11:00
 **/
@RestController
public class HelloController {

    @GetMapping("hello")
    public String getHello() {
        return "hello world";
    }
}
