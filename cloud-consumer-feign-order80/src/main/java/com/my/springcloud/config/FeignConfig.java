package com.my.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Gzy
 * @version 1.0
 * @Description
 * @date create on 2023/1/15
 */
@Configuration
public class FeignConfig {
    /**
     * Feign服务调用日志配置类
     * @return
     */
    @Bean
    Logger.Level feignLoggerLevel(){
        //此处表示输出最全级别的日志
        return Logger.Level.FULL;
    }
}
