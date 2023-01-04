package com.my.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Gzy
 * @version 1.0
 * @Description
 */
@SpringBootApplication
@EnableEurekaClient
public class PayMentMain8002 {

    public static void  main(String[] args){
        SpringApplication.run(PayMentMain8002.class,args);
    }

}
