package com.my.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;
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
    @HystrixCommand(
            //此处为该方法报错时调用的 备用方法名称
            fallbackMethod = "timeoutHandler",
            commandProperties = {
            //此处为该方法超时多久会调用 备用方法
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String paymentInfo_Timeout(Integer id){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池:" + Thread.currentThread().getName() + "paymentInfo_Timeout,id:" + id + "\t";
    }

    //超时 备用方法
    public String timeoutHandler(Integer id){
        return "服务器繁忙,请稍后再试 " + id;
    }

    ////////////////服务熔断////////////////

    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties =
            {
                    @HystrixProperty(name="circuitBreaker.enabled",value="true"),//是否开启断路器
                    @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value="10"),//(触发断路器的)请求次数
                    @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value="10000"),//(断路器跳闸之后多久会尝试重启)时间范围
                    @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value="60"),//(触发断路器的)失败率
            })
    public String paymentCircuitBreaker(Integer id){

        if(id < 0){
            throw new RuntimeException("id不能为负");
        }else{
            return "熔断测试方法:" + UUID.randomUUID().toString().replaceAll("-","");
        }

    }

    /**
     * 熔断缺省方法1
     * @param id
     * @return
     */
    public String paymentCircuitBreaker_fallback(Integer id){
        return "熔断缺省方法:" + id;
    }

}
