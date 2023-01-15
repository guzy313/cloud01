package com.my.springcloud.controller;

import com.my.springcloud.entity.CommonResult;
import com.my.springcloud.entity.Payment;
import com.my.springcloud.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Gzy
 * @version 1.0
 * @Description create on 2023/1/14
 */
@RestController
public class OrderController {
    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/payment/findAll")
    public CommonResult findAll(Payment payment){
        return paymentFeignService.findAll();
    }

    @GetMapping(value = "/payment/findById/{id}")
    public CommonResult findById(@PathVariable("id") long id){
        return paymentFeignService.findById(id);
    }

    @GetMapping("/payment/paymentFeignTimeout")
    public String paymentFeignTimeout(){
        return paymentFeignService.paymentFeignTimeout();
    }

}
