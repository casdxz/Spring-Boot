package com.bear.boot.websocket.service;

import com.bear.boot.websocket.server.WebSocketServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: bear
 * @create: 2022-04-18 14:14
 **/
@Service
@Slf4j
public class TaskService {
    @Resource
    private WebSocketServer webSocketServer;

    @Scheduled(cron = "0/5 * * * * ?")
    public void realTimeAlarm() {
        webSocketServer.sendToMessageById(1, "你工作时间已经超过5秒了，快休息一下吧");
    }
}
