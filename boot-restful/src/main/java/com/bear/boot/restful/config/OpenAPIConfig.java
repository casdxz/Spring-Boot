package com.bear.boot.restful.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: bear
 * @create: 2022-03-13 19:10
 **/
@Configuration
public class OpenAPIConfig {
    @Bean
    public GroupedOpenApi articleApi() {
        return GroupedOpenApi.builder().group("api-v1-articles").pathsToMatch("api/v1/articles/**").build();
    }

    @Bean
    public GroupedOpenApi helloApi() {
        return GroupedOpenApi.builder().group("hello").pathsToMatch("/hello/**").build();
    }
}
