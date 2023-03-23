package com.my.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.my.springcloud.domain.Order;
import com.my.springcloud.entity.CommonResult;
import com.my.springcloud.service.OrderService;
import io.netty.util.internal.StringUtil;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Gzy
 * @version 1.0
 * @Description
 * @date create on 2023/3/20
 */
@Controller
public class OrderController {
    @Resource
    private OrderService orderService;

    @ResponseBody
    @GetMapping("/order/getOrderList")
    public List<Order> getOrderList(){
        Map<String,Object> conditions = new HashMap<>();
        return orderService.findByMap(conditions);
    }

    /**
     * 创建订单
     * @return
     */
    @ResponseBody
    @GetMapping("/order/create")
    public CommonResult create(@RequestParam(value = "userId",required = true)Long userId,
                               @RequestParam(value = "productId",required = true)Long productId,
                               @RequestParam(value = "count",required = true)Integer count,
                               @RequestParam(value = "money",required = true) BigDecimal money){
        Order order = orderService.create(userId,productId,count,money);
        return new CommonResult(200,"订单创建成功",order);
    }

    /**
     * 支付订单
     * @param userId
     * @return
     */
    @GlobalTransactional(name = "tx-order-pay",
            timeoutMills = 6000,
            rollbackFor = Exception.class) //seata全局事务控制
    @ResponseBody
    @GetMapping("/order/pay")
    public CommonResult pay(@RequestParam("userId")Long userId,@RequestParam("e")String e){
        orderService.update(userId,e);
        return new CommonResult(200,"订单支付成功");
    }

}
