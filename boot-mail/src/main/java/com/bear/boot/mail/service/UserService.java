package com.bear.boot.mail.service;

/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: bear
 * @create: 2022-04-25 23:26
 **/
public interface UserService {
    public void activeUser(Integer id);
    public String insertUser(String username,String password);
}
