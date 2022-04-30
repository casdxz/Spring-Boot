package com.bear.boot.mail.service.impl;

import com.bear.boot.mail.entity.User;
import com.bear.boot.mail.mapper.UserMapper;
import com.bear.boot.mail.service.MailService;
import com.bear.boot.mail.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: bear
 * @create: 2022-04-25 23:28
 **/
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private MailService mailService;

    @Override
    public void activeUser(Integer id) {
        User user= User.builder().id(id).status(1).build();
        userMapper.updateStatus(user);
    }

    @Override
    public String insertUser(String username, String password) {
        User user = User.builder().username(username).password(password).status(0).build();
        User user1 = userMapper.selectById(username);
        if(user1 == null) {
            userMapper.insertUser(user);
            mailService.sendSimpleMail(username, "请激活您的用户", "http://localhost:8888/user/active/"+user.getId());
            return "注册成功，请前往您的邮箱进行激活";
        } else if(user1.getStatus() == 0){
            mailService.sendSimpleMail(username, "请激活您的用户", "http://localhost:8888/user/active/"+user1.getId());
            return "当前用户未激活， 请前往邮箱进行激活";
        } else {
            return "登录成功";
        }

    }
}
