package com.my.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Gzy
 * @version 1.0
 * @Description
 * @date create on 2023/3/10
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class CloudalibabaConsumerOrderMain84 {

    public static void main(String[] args) {
        SpringApplication.run(CloudalibabaConsumerOrderMain84.class,args);
    }

}
