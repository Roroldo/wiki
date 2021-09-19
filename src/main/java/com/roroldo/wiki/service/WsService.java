package com.roroldo.wiki.service;

import com.roroldo.wiki.websocket.WebSocketServer;
import org.slf4j.MDC;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class WsService {

    @Resource
    public WebSocketServer webSocketServer;

    /**
     * 异步发送消息（不能和调用方放在同一个类中）
     * @param message 消息
     * @param logId 日志 id
     */
    @Async
    public void sendInfo(String message, String logId) {
        MDC.put("LOG_ID", logId);
        webSocketServer.sendInfo(message);
    }
}
