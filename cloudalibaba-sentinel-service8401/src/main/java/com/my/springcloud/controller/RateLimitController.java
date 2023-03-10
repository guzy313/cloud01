package com.my.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.my.springcloud.entity.CommonResult;
import com.my.springcloud.handler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author Gzy
 * @version 1.0
 * @Description
 * @date create on 2023/3/9
 */
@RestController
public class RateLimitController {


    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handlerException")
    public CommonResult byResource(){
        return new CommonResult(200,"按资源名称限流",new Date());
    }

    public CommonResult handlerException(BlockException blockException){
        return new CommonResult(500,blockException.getClass().getCanonicalName() + "/t服务不可用");
    }

    @GetMapping("/testCustomerBlockHandler")
    @SentinelResource(
            value = "testCustomerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handlerException")
    public CommonResult testCustomerBlockHandler(){
        return new CommonResult(200,"testCustomerBlockHandler");
    }


}
