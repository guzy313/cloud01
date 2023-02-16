package com.my.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Gzy
 * @version 1.0
 * @Description
 * @date create on 2023/2/16
 */
@SpringBootApplication
@EnableEurekaClient
public class SpringCloudConfigClientMain {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfigClientMain.class,args);
    }

}
