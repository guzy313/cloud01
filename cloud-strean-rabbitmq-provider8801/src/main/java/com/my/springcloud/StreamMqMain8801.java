package com.my.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Gzy
 * @version 1.0
 * @Description
 * @date create on 2023/2/20
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamMqMain8801 {

    public static void main(String[] args) {
        SpringApplication.run(StreamMqMain8801.class,args);
    }

}
