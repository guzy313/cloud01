package com.my.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Gzy
 * @version 1.0
 * @Description 消息接收控制器
 * @date create on 2023/2/21
 */
@Controller
@EnableBinding(Sink.class)//绑定消息的接收管道
public class ReceiveMessageListenerController {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)//监听消息的接收管道
    public void input(Message<String> message){
        //获取并且打印推送的消息
        System.out.println("serverPort:" + serverPort + "消费者1号--->收到消息：" + message.getPayload());
    }

}
