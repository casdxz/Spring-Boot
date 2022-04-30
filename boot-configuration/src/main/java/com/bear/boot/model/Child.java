package com.bear.boot.model;

import lombok.Data;

import java.util.List;

/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: bear
 * @create: 2022-03-14 11:07
 **/
@Data
public class Child {

    private String name;

    private Integer age;

    private List<Friend> friends;
}
