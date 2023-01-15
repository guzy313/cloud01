package com.my.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Gzy
 * @version 1.0
 * @Description create on 2023/1/14
 */
@SpringBootApplication
//@EnableDiscoveryClient
@EnableFeignClients
public class OrderFeignMain {

    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMain.class,args);
    }

}
