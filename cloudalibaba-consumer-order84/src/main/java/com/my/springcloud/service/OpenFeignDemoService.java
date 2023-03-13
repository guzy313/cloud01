package com.my.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Gzy
 * @version 1.0
 * @Description
 * @date create on 2023/3/12
 */
@Service
@FeignClient(value = "cloudalibaba-provider-payment")
public interface OpenFeignDemoService {
    @GetMapping("/demoRemoteInfo")
    public String demoRemoteInfo();
}
