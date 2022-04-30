package com.bear.boot.listener;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: bear
 * @create: 2022-04-04 21:02
 **/
@SpringBootTest
@ExtendWith(SpringExtension.class)
class CustomListenerTest {

    @Resource
    private ApplicationContext context;

    @Test
    void testEvent() {
        context.publishEvent(new MyEvent("测试事件"));
    }
}