package com.my.springcloud.controller;

import com.my.springcloud.service.OrderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Gzy
 * @version 1.0
 * @Description
 * @date create on 2023/1/17
 */
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Value("${server.port}")
    private String serverPort;


    /**
     * 访问成功模拟
     * @param id
     * @return
     */
    @GetMapping(value = "/hystrix/payment/paymentInfo_OK/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        return "服务端口：" + serverPort + orderService.paymentInfo_OK(id);
    }

    /**
     * 超时模拟
     * @return
     */
    @HystrixCommand(fallbackMethod = "timeoutHandler", commandProperties = {
        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
    }
    )
    @GetMapping(value = "hystrix/payment/paymentInfo_Timeout/{id}")
    public String paymentInfo_Timeout(@PathVariable("id") Integer id){
        return "服务端口：" + serverPort + orderService.paymentInfo_Timeout(id);
    }

    /**
     * 备用方法
     */
    public String timeoutHandler(Integer id){
        return "(order模块)服务器繁忙,请稍后再试 " + id;
    }

}
