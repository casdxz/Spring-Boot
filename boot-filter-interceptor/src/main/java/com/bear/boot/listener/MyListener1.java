package com.bear.boot.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;

/**
 * @program: IntelliJ IDEA
 * @description: 自定义事件监听器方式1:实现ApplicationListener接口
 * @author: bear
 * @create: 2022-04-04 20:52
 **/
@Slf4j
public class MyListener1 implements ApplicationListener<MyEvent> {
    @Override
    public void onApplicationEvent(MyEvent event) {
        log.info(String.format("%s 监听到事件源: %s.",MyListener1.class.getName(),
                event.getSource()));
    }
}