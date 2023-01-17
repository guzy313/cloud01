package com.my.springcloud.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author Gzy
 * @version 1.0
 * @Description 测试Hystrix
 * @date create on 2023/1/17
 */
@Service
public class PaymentService {

    //访问成功模拟
    public String paymentInfo_OK(Integer id){
        return "线程池:" + Thread.currentThread().getName() + "paymentInfo_OK,id:" + id + "\t";
    }

    //超时模拟
    public String paymentInfo_Timeout(Integer id){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池:" + Thread.currentThread().getName() + "paymentInfo_Timeout,id:" + id + "\t";
    }

    //异常模拟



}
