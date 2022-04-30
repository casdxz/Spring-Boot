package com.bear.boot.service;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: bear
 * @create: 2022-03-14 14:56
 **/
@Slf4j
@Data
@ExtendWith(SpringExtension.class)
class TestBeanServiceTest {
        //注入Spring上下文环境
    @Resource
    private ConfigurableApplicationContext ioc;

    @Test
    void testLoadService(){
        //测试环境的Spring上下文中读取xml配置文件，得到testBeanService,
        //boolean flag = ioc.containsBean("testBeanService");
        //assertTrue(flag);
        TestBeanService tbs = (TestBeanService)ioc.getBean("testBeanService");

        log.info(tbs.getName());
        assertEquals("SpringBoot",tbs.getName());

    }

}