package com.my.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Gzy
 * @version 1.0
 * @Description
 * @date create on 2023/3/10
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudalibabaProviderMain9003 {


    public static void main(String[] args) {
        SpringApplication.run(CloudalibabaProviderMain9003.class,args);
    }

}
