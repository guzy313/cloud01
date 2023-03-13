package com.my.springcloud.handler;

/**
 * @author Gzy
 * @version 1.0
 * @Description
 * @date create on 2023/3/12
 */
public class SentinelCustomerFallbackHandler {

    //注意点：方法参数列表需要和原函数一致，或者可以额外多一个 Throwable 类型的参数用于接收对应的异常。

    /**
     *
     * @param e
     * @return
     */
    public static String fallbackHandlerForPaymentController(Throwable e){
        StringBuilder result = new StringBuilder();
        result.append("hihi,here is fallbackHandlerForPaymentController... ")
                .append("<br/>with Exception message: ")
                .append(e.getMessage());
        return result.toString();
    }

    /**
     * 携带参数:id 的方法的异常回调方法
     * @param e
     * @return
     */
    public static String fallbackHandlerForPaymentControllerWithParamId(String id,Throwable e){
        StringBuilder result = new StringBuilder();
        result.append("hihi,here is fallbackHandlerForPaymentControllerWithParamId... ")
                .append("<br/>with Exception message: ")
                .append(e.getMessage());
        return result.toString();
    }

}
