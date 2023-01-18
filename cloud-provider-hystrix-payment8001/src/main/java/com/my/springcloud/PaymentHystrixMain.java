package com.my.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Gzy
 * @version 1.0
 * @Description
 * @date create on 2023/1/16
 */

@SpringBootApplication
@EnableEurekaClient
//配合@HystrixCommand 使用 方法调用报错、超时等情况 回调预定义方法
@EnableCircuitBreaker
public class PaymentHystrixMain {

    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrixMain.class,args);
    }

}
