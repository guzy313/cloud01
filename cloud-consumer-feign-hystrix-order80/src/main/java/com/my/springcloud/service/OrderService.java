package com.my.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Gzy
 * @version 1.0
 * @Description
 * @date create on 2023/1/17
 */
@FeignClient("CLOUD-PAYMENT-HYSTRIX-SERVICE")
public interface OrderService {

    /**
     * 访问成功模拟
     * @param id
     * @return
     */
    @GetMapping(value = "/hystrix/payment/paymentInfo_OK/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id);

    /**
     * 超时模拟
     * @return
     */
    @GetMapping(value = "hystrix/payment/paymentInfo_Timeout/{id}")
    public String paymentInfo_Timeout(@PathVariable("id") Integer id);


}