package com.my.springcloud.controller;

import com.my.springcloud.entity.CommonResult;
import com.my.springcloud.entity.Payment;
import com.my.springcloud.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author Gzy
 * @version 1.0
 * @Description
 */
@RestController
public class PaymentController {
    private static final Logger log = LoggerFactory.getLogger(PaymentController.class);
    @Autowired
    private PaymentService paymentService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/add")
    public CommonResult add(@RequestBody Payment payment){
        int result = paymentService.add(payment);
        log.info("***新增结果:" + result);
        if(result > 0){
            return new CommonResult(200,"新增成功",result);
        }
        return new CommonResult(500,"新增失败");
    }


    @GetMapping(value = "/payment/findAll")
    public CommonResult findAll(Payment payment){
        List<Payment> list = paymentService.findList();
        if(list.size() > 0){
            return new CommonResult(200,"查询成功",list);
        }
        return new CommonResult(500,"没有对应记录");
    }


    @GetMapping(value = "/payment/findById/{id}")
    public CommonResult findById(@PathVariable("id") long id){
        Payment payment = paymentService.findById(id);
        System.out.println(123);
        if(payment != null){
            return new CommonResult(200,"查询成功",payment);
        }
        return new CommonResult(500,"没有对应记录");
    }


    @PostMapping(value = "/payment/delete")
    public CommonResult delete(@RequestBody Payment payment){
        int result = paymentService.delete(payment.getId());
        log.info("***删除结果:" + result);
        if(result > 0){
            return new CommonResult(200,"删除成功",result);
        }
        return new CommonResult(500,"删除失败");
    }


    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        return services;
    }


}
