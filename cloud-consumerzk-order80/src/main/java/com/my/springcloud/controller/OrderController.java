package com.my.springcloud.controller;

import com.my.springcloud.entity.CommonResult;
import com.my.springcloud.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Gzy
 * @version 1.0
 * @Description: 消费者模块控制器
 */
@RestController
public class OrderController {

    //此处声明需要调用的微服务名称(多个功能一致的微服务负载均衡名称保持一致)
    public static final String PAYMENT_URL = "http://cloud-provider-payment";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/order/getPaymentZk")
    public String getPaymentZk(){
        return restTemplate.getForObject(PAYMENT_URL + "/payment/zk",String.class);
    }

}
