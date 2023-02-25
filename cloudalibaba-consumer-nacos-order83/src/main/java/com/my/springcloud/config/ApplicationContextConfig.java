package com.my.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Gzy
 * @version 1.0
 * @Description
 * @date create on 2023/2/25
 */
@Configuration
public class ApplicationContextConfig {
    @LoadBalanced//负载均衡注解(关键)
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
