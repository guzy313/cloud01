package com.my.springcloud.controller;

import com.my.springcloud.service.OpenFeignDemoService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author Gzy
 * @version 1.0
 * @Description
 * @date create on 2023/3/10
 */
@RestController
public class OrderController {
    @Value("${server.port}")
    private String serverPort;
    @Value("${spring.application.name}")
    private String serverName;

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private OpenFeignDemoService openFeignDemoService;

    private static String SERVER_URL = "http://cloudalibaba-provider-payment";


    @GetMapping("/getDemoInfoFromRemote")
    public String getDemoInfoFromRemote() {
        StringBuilder result = new StringBuilder();
        //获取远程服务信息
        String resultFromRemote =
                restTemplate.getForObject(OrderController.SERVER_URL + "/demoRemoteInfo",String.class);
        result.append("here is consumer,get info from remote:\r\n")
                .append("{")
                .append(resultFromRemote)
                .append("\r\n}");
        return result.toString();
    }

    @GetMapping("/getDemoRemoteInfoByOpenFeign")
    public String getDemoRemoteInfoByOpenFeign(){
        StringBuilder result = new StringBuilder(" from provider by openfeign:");
        result.append("<br/>")
                .append(openFeignDemoService.demoRemoteInfo());

        return result.toString();
    }


}
