package com.bear.boot.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: bear
 * @create: 2022-03-07 16:21
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Slf4j
public class Book {
    private Integer id;
    private String name;

    private static Logger logger = LoggerFactory.getLogger(Book.class);

}
