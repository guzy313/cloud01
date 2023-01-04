package com.my.springcloud.controller;

import com.my.springcloud.entity.CommonResult;
import com.my.springcloud.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import sun.dc.pr.PRError;

/**
 * @author Gzy
 * @version 1.0
 * @Description: 消费者模块控制器
 */
@RestController
public class OrderController {

    //此处声明需要调用的微服务名称(多个功能一致的微服务负载均衡名称保持一致)
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";
//    public static final String PAYMENT_URL = "http://localhost:8001/";

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/consumer/payment/add")
    public CommonResult<Payment> add(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL + "/payment/add",payment,CommonResult.class);
    }


    @GetMapping("/consumer/payment/findById/{id}")
    public CommonResult<Payment> findById(@PathVariable("id")long id){
        return restTemplate.getForObject(PAYMENT_URL + "/payment/findById/"+id,CommonResult.class);
    }

    @GetMapping("/consumer/payment/findAll")
    public CommonResult<Payment> findAll(){
        return restTemplate.getForObject(PAYMENT_URL + "/payment/findAll",CommonResult.class);
    }

}
