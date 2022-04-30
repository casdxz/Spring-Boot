package com.bear.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: bear
 * @create: 2022-03-14 11:06
 **/
@SpringBootApplication
@ImportResource(locations = {"classpath:bean.xml"})
public class BootConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(BootConfigApplication.class,args);
    }
}
