package com.my.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Controller;

/**
 * @author Gzy
 * @version 1.0
 * @Description
 * @date create on 2023/2/22
 */
@Controller
@EnableBinding(Sink.class)//消息接收通道Sink
public class ReceiveMessageListenerController {
    @Value("${server.port}")
    private String serverPort;


    @StreamListener(Sink.INPUT)//监听的消息通道名称(输入通道input)
    public void receiveMessage(Message<String> message){
        System.out.println("serverPort:" + serverPort + "消费者2号--->收到消息:" + message.getPayload());
    }
}
