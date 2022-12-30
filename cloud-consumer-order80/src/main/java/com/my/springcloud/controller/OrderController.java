package com.my.springcloud.controller;

import com.my.springcloud.entity.CommonResult;
import com.my.springcloud.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import sun.dc.pr.PRError;

/**
 * @author Gzy
 * @version 1.0
 * @Description
 */
@RestController
public class OrderController {
    public static final String PAYMENT_URL = "http://localhost:8001/";

    @Autowired
    private RestTemplate restTemplate;


    public CommonResult<Payment> add(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL + "/payment/add",payment,CommonResult.class);
    }



}
