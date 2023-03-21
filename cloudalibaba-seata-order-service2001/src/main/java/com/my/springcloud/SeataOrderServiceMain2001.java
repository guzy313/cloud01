package com.my.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Gzy
 * @version 1.0
 * @Description
 * @date create on 2023/3/20
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SeataOrderServiceMain2001 {

    public static void main(String[] args) {
        SpringApplication.run(SeataOrderServiceMain2001.class,args);
    }

}
