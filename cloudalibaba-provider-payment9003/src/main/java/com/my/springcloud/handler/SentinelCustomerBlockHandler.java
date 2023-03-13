package com.my.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @author Gzy
 * @version 1.0
 * @Description
 * @date create on 2023/3/10
 */
public class SentinelCustomerBlockHandler {


    public static String blockHandlerForPaymentController(BlockException blockException) {
        return "hihi,here is blockHandlerForPaymentController...";
    }

}
