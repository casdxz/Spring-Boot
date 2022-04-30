package com.bear.boot.websocket.server;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: bear
 * @create: 2022-04-18 14:04
 **/
@ServerEndpoint(value = "/socket/{id}")
@Component
@Slf4j
public class WebSocketServer {
    /**
     * 静态变量，用来记录当前在线的连接数
     */
    private static int onlineCount = 0;

    /**
     * concurrent包中的线程安全的Set，用来存放每个客户端对应的MyWebSocket对象
     */
    public static ConcurrentHashMap<Integer, WebSocketServer> webSocketSet = new ConcurrentHashMap<>();

    /**
     * 与每个客户端的连接会话，获取参数，发送数据
     */
    private Session session;

    /**
     * 传过来的id
     */
    private Integer id = 0;

    /**
     * 连接建立成功，调用该方法
     *
     * @param session 会话
     */
    @OnOpen
    public void opOpen(@PathParam(value = "id") Integer param, Session session) {
        //接受到发送消息的人员编号
        this.id = param;
        this.session = session;
        //加入set中
        webSocketSet.put(param,this);
        //在线数加1
        addOnlineCount();
        log.info("有新连接加入，当前在线人数为:" + getOnlineCount());
        try {
            sendMessage("-连接已建立-");
        } catch (IOException e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        if(id != null && id != 0){
            //从set中删除
            webSocketSet.remove(id);
            //在线数减1
            subOnlineCount();
            log.info("有一连接关闭！当前在线人数为:" + getOnlineCount());
        }
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 消息
     * @param session 会话
     * @throws IOException IO异常
     */
    @OnMessage
    public void onMessage(String message, Session session){
        log.info("来自客户端的消息:" + message);
        try {
            this.sendMessage(message);
        }catch (IOException e){
            log.error(e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 发生错误时调用
     * @param error
     */
    @OnError
    public void onError(Session session,Throwable error) {
        log.info("发送错误");
        error.printStackTrace();
    }

    public void sendMessage(String message) throws IOException {
        getSession().getBasicRemote().sendText(message);
    }

    public void sendToMessageById(Integer id,String message){
        try {
            if (webSocketSet.get(id) != null) {
                webSocketSet.get(id).sendMessage(message);
            }else {
                log.info("webSocketSet中没有此key,不推送消息");
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void sendInfo(String message) throws IOException {
        for (WebSocketServer item : webSocketSet.values()) {
            try {
                item.sendMessage(message);
            }catch (IOException e){
                log.error(e.getMessage());
                e.printStackTrace();
            }
        }
    }


    public Session getSession() {
        return session;
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        WebSocketServer.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocketServer.onlineCount--;
    }
}
