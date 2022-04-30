package com.bear.boot.template.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: bear
 * @create: 2022-04-04 18:42
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Article {

    private Integer id;

    private String author;

    private String title;
}
