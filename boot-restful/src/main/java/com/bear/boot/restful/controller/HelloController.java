package com.bear.boot.restful.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: bear
 * @create: 2022-03-13 19:11
 **/
@RestController
@RequestMapping(value = "hello")
public class HelloController {
    @GetMapping("world")
    public String getHelloWorld() {
        return "hello world";
    }
}
