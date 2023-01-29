package com.my.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author Gzy
 * @version 1.0
 * @Description
 * @date create on 2023/1/28
 */
@SpringBootApplication
@EnableEurekaClient
//启用Hystrix图形监控
@EnableHystrixDashboard
public class ConsumerHystrixDashboard {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerHystrixDashboard.class,args);
    }

}
