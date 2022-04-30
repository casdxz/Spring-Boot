package com.bear.boot.model;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import java.util.Date;

/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: bear
 * @create: 2022-03-14 14:16
 **/
@Data
public class Book {

    private String name;

    @Min(value = 20,message = "价格不小于50元")
    private Double price;

    @Past
    private Date time;
}
