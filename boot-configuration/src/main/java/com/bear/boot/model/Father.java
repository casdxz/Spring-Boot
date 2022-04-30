package com.bear.boot.model;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;

/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: bear
 * @create: 2022-03-14 11:08
 **/
@Data
public class Father {
    private String name;

    @Min(value = 22, message = "爸爸年龄不能小于22岁")

    private Integer age;
    @Email
    private String email;
}
