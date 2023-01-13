package com.my.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Gzy
 * @version 1.0
 * @Description create on 2023/1/13
 */
@Configuration
public class MySelfRule {
    /**
     * 配置ribbon 负载均衡策略为 随机
     * @return
     */
    @Bean
    public IRule myRule(){
        return new RandomRule();
    }
}
