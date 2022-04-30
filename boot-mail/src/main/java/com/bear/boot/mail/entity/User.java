package com.bear.boot.mail.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: bear
 * @create: 2022-04-25 23:19
 **/
@Data
@Builder
public class User {
    private Integer id;
    private String username;
    private String password;
    private Integer status;
    private String avatar;
}
