package com.my.springcloud;

import com.my.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Gzy
 * @version 1.0
 * @Description
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
//注意此处指向的微服务名称 在注册中心是大写就必须是大写,小写会不生效
@RibbonClient(name="CLOUD-PAYMENT-SERVICE",configuration = MySelfRule.class)
public class OrderMain80 {

    public static void main(String[] args){
        SpringApplication.run(OrderMain80.class,args);
    }

}
