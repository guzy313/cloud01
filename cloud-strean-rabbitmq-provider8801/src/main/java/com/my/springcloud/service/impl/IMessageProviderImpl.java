package com.my.springcloud.service.impl;

import com.my.springcloud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;

import java.util.UUID;

/**
 * @author Gzy
 * @version 1.0
 * @Description 调用消息中间件 接口实现
 * @date create on 2023/2/20
 */
@EnableBinding(Source.class)//定义消息的推送管道
public class IMessageProviderImpl implements IMessageProvider {
    @Resource
    private MessageChannel output;//消息发送管道


    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        boolean send = output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("*****serial:" + serial);
        return serial;
    }
}
