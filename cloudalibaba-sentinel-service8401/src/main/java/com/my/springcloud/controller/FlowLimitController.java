package com.my.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import io.netty.util.internal.StringUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author Gzy
 * @version 1.0
 * @Description 流量监控控制器
 * @date create on 2023/3/4
 */
@RestController
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA(){
        return "testA...";
    }
    @GetMapping("/testB")
    public String testB(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:MM:ss");
        System.out.println(sdf.format(new Date()));
        return "testB...";
    }


    @GetMapping("/testTimeout")
    public String testTimeout(){
        long s = System.currentTimeMillis();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long e = System.currentTimeMillis();
        return "耗时:" + (e - s) + "...";
    }

    @GetMapping("/testException")
    public String testException(@RequestParam("id")String id){
        String info = "testException..";
        if("1".equals(id)){
            System.out.println("testException..");
            return info;
        }else{
            throw new RuntimeException("预置错误..");
        }
    }

    @GetMapping("/testExceptionRestful/{id}")
    public String testExceptionRestful(@PathVariable("id")String id){
        String info = "testExceptionRestful..";
        if("1".equals(id)){
            System.out.println("testException..");
            return info;
        }else{
            throw new RuntimeException("预置错误RESTFUL..");
        }
    }

    /**
     * 热点规则测试方法
     * @param keyword1
     * @param keyword2
     * @return
     */
    @GetMapping("/getHotKey")
    @SentinelResource(value = "getHotKey",blockHandler = "deal_getHotKey")
    public String getHotKey(@RequestParam(value = "keyword1",required = false) String keyword1,
                            @RequestParam(value = "keyword2",required = false) String keyword2){
        return " from getHotKey:\n key1["+keyword1+"]\n key2["+keyword2+"]" ;
    }

    /**
     * getHotKey 的 fallback方法 更改sentinel默认提示
     * @param keyword1
     * @param keyword2
     * @param blockException
     * @return
     */
    public String deal_getHotKey(String keyword1, String keyword2, BlockException blockException){
        return "deal_getHotKey..";
    }

}
