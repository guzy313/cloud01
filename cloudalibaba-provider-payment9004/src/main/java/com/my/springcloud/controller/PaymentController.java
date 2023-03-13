package com.my.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.my.springcloud.handler.SentinelCustomerBlockHandler;
import com.my.springcloud.handler.SentinelCustomerFallbackHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author Gzy
 * @version 1.0
 * @Description
 * @date create on 2023/3/10
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;
    @Value("${spring.application.name}")
    private String serverName;

    @GetMapping("/demoRemoteInfo")
    @SentinelResource(value = "demoRemoteInfo",
            blockHandlerClass = SentinelCustomerBlockHandler.class,
            blockHandler = "blockHandlerForPaymentController")
    public String demoRemoteInfo() {
        StringBuilder result = new StringBuilder();
        result.append(" from ")
                .append(serverName)
                .append(",port:")
                .append(serverPort)
                .append(",")
                .append("demoRemoteInfo");
        return result.toString();
    }


    /**
     * 测试Sentinel异常回调方法
     * @param
     * @return
     */
    @GetMapping("/testPaymentFallback")
    @SentinelResource(value = "testPaymentFallback",
            fallbackClass = SentinelCustomerFallbackHandler.class,
            fallback = "fallbackHandlerForPaymentController"
            )
    public String testPaymentFallback(){
        String id = "1";
        if("1".equals(id)){
            throw new NullPointerException("测试指定空指针异常");
        }
        if("2".equals(id)){
            throw new IndexOutOfBoundsException("测试指定数组越界异常");
        }

        StringBuilder result = new StringBuilder();
        result.append(" from ")
                .append(serverName)
                .append(",port:")
                .append(serverPort)
                .append(",")
                .append("testPaymentFallback");
        return result.toString();
    }

    /**
     * 测试Sentinel 带参数id 的异常回调方法
     * @param id
     * @return
     */
    @GetMapping("/testPaymentFallbackWithParamId")
    @SentinelResource(value = "testPaymentFallbackWithParamId",
            fallbackClass = SentinelCustomerFallbackHandler.class,
            fallback = "fallbackHandlerForPaymentControllerWithParamId",
            exceptionsToIgnore = {IndexOutOfBoundsException.class}
    )
    public String testPaymentFallback(String id){

        if("1".equals(id)){
            throw new NullPointerException("测试指定空指针异常");
        }
        if("2".equals(id)){
            throw new IndexOutOfBoundsException("测试指定数组越界异常");
        }

        StringBuilder result = new StringBuilder();
        result.append(" from ")
                .append(serverName)
                .append(",port:")
                .append(serverPort)
                .append(",")
                .append("testPaymentFallback");
        return result.toString();
    }


}
