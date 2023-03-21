package com.my.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Gzy
 * @version 1.0
 * @Description
 * @date create on 2023/3/20
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)//取消数据源自动装配
@EnableFeignClients//启用Openfeign远程调用
@EnableDiscoveryClient
public class SeataOrderServiceMain2001 {

    public static void main(String[] args) {
        SpringApplication.run(SeataOrderServiceMain2001.class,args);
    }

}
