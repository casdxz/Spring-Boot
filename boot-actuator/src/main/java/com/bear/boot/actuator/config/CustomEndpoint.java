package com.bear.boot.actuator.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.context.annotation.Configuration;

/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: bear
 * @create: 2022-04-15 08:56
 **/
@Configuration
@Endpoint(id = "customEndpoint")
public class CustomEndpoint {

    @ReadOperation
    public ShopData getData() {
        return new ShopData("zhangsan","江苏南京");

    }

    @Data
    @AllArgsConstructor
    public static class ShopData{
        private String name;
        private String address;
    }
}
