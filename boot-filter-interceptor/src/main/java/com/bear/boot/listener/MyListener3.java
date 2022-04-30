package com.bear.boot.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;

/**
 * @program: IntelliJ IDEA
 * @description: 自定义事件监听器方式3:在application.properties中配置监听
 * @author: bear
 * @create: 2022-04-04 20:53
 **/
@Slf4j
public class MyListener3 implements ApplicationListener<MyEvent> {
    @Override
    public void onApplicationEvent(MyEvent event) {
        log.info(String.format("%s 监听到事件源: %s.",MyListener3.class.getName(),
                event.getSource()));
    }
}