package com.my.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Gzy
 * @version 1.0
 * @Description
 * @date create on 2023/3/4
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Sentinel8401Main {

    public static void main(String[] args) {
        SpringApplication.run(Sentinel8401Main.class,args);
    }

}
