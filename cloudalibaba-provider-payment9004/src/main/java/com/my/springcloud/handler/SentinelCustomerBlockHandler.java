package com.my.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @author Gzy
 * @version 1.0
 * @Description
 * @date create on 2023/3/10
 */
public class SentinelCustomerBlockHandler {
    //注意点：方法参数列表需要和原函数一致，或者可以额外多一个 BlockException 类型的参数用于接收对应的异常。

    public static String blockHandlerForPaymentController(BlockException blockException) {
        return "hihi,here is blockHandlerForPaymentController...";
    }

}
