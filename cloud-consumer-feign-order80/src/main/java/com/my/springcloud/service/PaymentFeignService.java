package com.my.springcloud.service;

import com.my.springcloud.entity.CommonResult;
import com.my.springcloud.entity.Payment;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author Gzy
 * @version 1.0
 * @Description create on 2023/1/14
 */
@Component
//指定要调用的微服务名称
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping(value = "/payment/findAll")
    public CommonResult findAll();


    @GetMapping(value = "/payment/findById/{id}")
    public CommonResult findById(@PathVariable("id") long id);

}
