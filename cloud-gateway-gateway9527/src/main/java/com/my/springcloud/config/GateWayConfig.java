package com.my.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Gzy
 * @version 1.0
 * @Description gateway网关的配置类 配置路由
 * @date create on 2023/1/29
 */
@Configuration
public class GateWayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        //https://news.baidu.com/guonei
        //此处配置两个路由，一个指向百度国内新闻，一个指向百度游戏新闻
        routes
                .route("path_route1",
                    r -> r.path("/guonei").uri("https://news.baidu.com/guonei")
                )
                .route("path_route5",
                        r -> r.path("/game").uri("https://news.baidu.com/game")
                )
                .build();
        return routes.build();
    }

    @Bean
    public RouteLocator customRouteLocator1(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        //https://news.baidu.com/guonei
        //此处配置两个路由，一个指向百度国内新闻，一个指向百度游戏新闻
        routes.route("path_route7",
                        r -> r.path("/guoji").uri("https://news.baidu.com/guonei")
                )
                .build();
        return routes.build();
    }

}
