package com.bear.boot.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: bear
 * @create: 2022-03-14 14:17
 **/
@Data
@Component
/**配置整体前缀*/
@ConfigurationProperties(prefix = "user")
@PropertySource(value = {"classpath:user.yml"})
@Validated
public class User {

    @Length(min = 5, max = 20, message = "书名长度必须在5-20之间。")
    private String name;

    private Integer age;

    private Book book;
}
