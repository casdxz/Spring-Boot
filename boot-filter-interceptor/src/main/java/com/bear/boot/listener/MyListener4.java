package com.bear.boot.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @program: IntelliJ IDEA
 * @description: 自定义事件监听器方式4: 使用@eventListenr装饰具体方法
 * @author: bear
 * @create: 2022-04-04 20:53
 **/
@Slf4j
@Component
public class MyListener4 {
    @EventListener
    public void listener(MyEvent event) {
        log.info(String.format("%s 监听到事件源: %s.",MyListener4.class.getName(),
                event.getSource()));
    }
}

