package com.my.springcloud.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author Gzy
 * @version 1.0
 * @Description
 * @date create on 2023/2/13
 */
@Component
public class customLogGatewayGlobalFilter implements GlobalFilter, Ordered {


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String xxx = exchange.getRequest().getQueryParams().getFirst("xxx");
        //如果不存在这个参数,则不允许访问
        if(xxx == null){
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }

        return chain.filter(exchange);
    }

    //加载过滤器的顺序(数字越小优先级越高)
    @Override
    public int getOrder() {
        return 0;
    }
}
