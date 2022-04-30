package com.bear.boot;

import com.bear.boot.listener.MyEvent;
import com.bear.boot.listener.MyListener1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: bear
 * @create: 2022-04-04 10:44
 **/
@SpringBootApplication
//@ServletComponentScan
public class Application {
    public static void main(String[] args) {
        //SpringApplication.run(Application.class,args);

        //获取ConfigurableApplicationContext上下文
        ConfigurableApplicationContext context =  SpringApplication.run(Application.class,args);

        //装载监听
        context.addApplicationListener(new MyListener1());
        //发布事件
        context.publishEvent(new MyEvent("测试事件"));
    }
}
