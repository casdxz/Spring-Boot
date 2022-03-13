package com.bear.boot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: bear
 * @create: 2022-03-07 14:55
 **/
@RestController
public class HelloController {
    @GetMapping(value = "/hello")
    public String getHello(){
        return "hello world";
    }
}
