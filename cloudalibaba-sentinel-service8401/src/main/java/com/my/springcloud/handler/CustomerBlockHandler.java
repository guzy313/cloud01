package com.my.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.my.springcloud.entity.CommonResult;

import java.util.Date;

/**
 * @author Gzy
 * @version 1.0
 * @Description sentinel自定义流控处理类
 * @date create on 2023/3/9
 */
public class CustomerBlockHandler {

    public static CommonResult handlerException(BlockException blockException){
        return new CommonResult(500,
                blockException.getClass().getCanonicalName() + " 公共自定义错误",
                new Date());
    }

    public static CommonResult handlerException1(BlockException blockException){
        return new CommonResult(500,
                blockException.getClass().getCanonicalName() + " 公共自定义错误1",
                new Date());
    }

    public static CommonResult handlerException2(BlockException blockException){
        return new CommonResult(500,
                blockException.getClass().getCanonicalName() + " 公共自定义错误2",
                new Date());
    }
}
