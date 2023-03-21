package com.my.springcloud.controller;

import com.my.springcloud.domain.Order;
import com.my.springcloud.entity.CommonResult;
import com.my.springcloud.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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
     * @param order
     * @return
     */
    @ResponseBody
    @PostMapping("/order/create")
    public CommonResult create(@RequestParam Order order){
        orderService.create(order);
        return new CommonResult(200,"订单创建成功");
    }

    /**
     * 支付订单
     * @param order
     * @return
     */
    @ResponseBody
    @PostMapping("/order/pay")
    public CommonResult pay(@RequestParam("userId")Long userId){
        orderService.update(userId);
        return new CommonResult(200,"订单支付成功");
    }

}
