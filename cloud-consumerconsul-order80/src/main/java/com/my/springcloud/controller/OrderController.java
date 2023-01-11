package com.my.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {
    private final static String SERVICE_URL = "http://cloud-provider-payment";

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping(value = "/order/getConsumerInfoDemo")
    public String getConsumerInfoDemo(){
        return restTemplate.getForObject(SERVICE_URL + "/payment/paymentConsul",String.class);
    }






}
