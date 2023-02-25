package com.my.springcloud.controller;

import com.my.springcloud.entity.CommonResult;
import com.my.springcloud.entity.Payment;
import com.my.springcloud.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;


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

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/add")
    public CommonResult add(@RequestBody Payment payment){
        int result = paymentService.add(payment);
        log.info("***新增结果:" + result);
        if(result > 0){
            return new CommonResult(200,"新增成功,serverPort:" + serverPort ,result);
        }
        return new CommonResult(500,"新增失败");
    }


    @GetMapping(value = "/payment/findAll")
    public CommonResult findAll(Payment payment){
        List<Payment> list = paymentService.findList();
        if(list.size() > 0){
            return new CommonResult(200,"查询成功,serverPort:" + serverPort,list);
        }
        return new CommonResult(500,"没有对应记录");
    }


    @GetMapping(value = "/payment/findById/{id}")
    public CommonResult findById(@PathVariable("id") long id){
        Payment payment = paymentService.findById(id);
        System.out.println(123);
        if(payment != null){
            return new CommonResult(200,"查询成功,serverPort:" + serverPort,payment);
        }
        return new CommonResult(500,"没有对应记录");
    }


    @PostMapping(value = "/payment/delete")
    public CommonResult delete(@RequestBody Payment payment){
        int result = paymentService.delete(payment.getId());
        log.info("***删除结果:" + result);
        if(result > 0){
            return new CommonResult(200,"删除成功,serverPort:" + serverPort,result);
        }
        return new CommonResult(500,"删除失败");
    }


    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        //获取所有的微服务名称
        List<String> services = discoveryClient.getServices();
        for (String s:services ) {
            log.info("=== element:" + s);
        }
        //通过微服务名称获取(可以获取到所有相同名称的微服务实例信息)
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        for (ServiceInstance instance:instances) {
            log.info(instance.getServiceId() + "\n" + instance.getHost() + "\n" + instance.getPort() + "\n" + instance.getUri());
        }

        return this.discoveryClient;
    }

    @GetMapping("/payment/paymentFeignTimeout")
    public String paymentFeignTimeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort + "延迟执行方法-测试feign调用超时情况";
    }

    @GetMapping("/payment/getZipkinStr")
    public String getZipkinStr(){
        return "serverPort:" + serverPort + "  here is zipkin ";
    }

}
