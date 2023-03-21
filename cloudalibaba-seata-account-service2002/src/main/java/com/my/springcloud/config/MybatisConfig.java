package com.my.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Gzy
 * @version 1.0
 * @Description mybatis配置 配置扫描的mybatis dao文件
 * @date create on 2023/3/21
 */
@Configuration
@MapperScan({"com.my.springcloud.dao"})
public class MybatisConfig {

}
