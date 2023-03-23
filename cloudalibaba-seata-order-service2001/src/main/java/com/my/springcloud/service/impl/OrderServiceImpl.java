package com.my.springcloud.service.impl;

import com.my.springcloud.dao.OrderDao;
import com.my.springcloud.domain.Order;
import com.my.springcloud.service.AccountService;
import com.my.springcloud.service.OrderService;
import com.my.springcloud.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author Gzy
 * @version 1.0
 * @Description
 * @date create on 2023/3/20
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;

    //账户服务远程调用
    @Resource
    private AccountService accountService;

    //库存服务远程调用
    @Resource
    private StorageService storageService;

    @Override
    public List<Order> findByMap(Map<String,Object> columns){
        return orderDao.findAll();
    }

    @Override
    public Order create(Long userId,Long productId,Integer count,BigDecimal money){

        Order order = new Order();
        order.setId(orderDao.findMaxId() + 1);//查询最大ID实现自增[数据库表主键自增策略会导致seata事务回滚锁表]
        order.setProductId(productId);
        order.setCount(count);
        order.setMoney(money);
        order.setUserId(userId);
        order.setStatus(0);
        System.out.println("订单开始创建..");

        orderDao.insert(order);
        System.out.println("----->开始修改订单状态..");

        System.out.println("下订单成功！");
        return order;
    }

    @Override
    public void update(Long userId,String e){
        System.out.println("开始支付");
        List<Order> orderList = orderDao.findByUserId(userId);
        for (Order order:orderList) {
            if(!"0".equals(String.valueOf(order.getStatus())))continue;//只支付未支付的订单
            System.out.println("----->开始调用订单微服务..");
            storageService.decrease(order.getProductId(),order.getCount(),e);
            System.out.println("----->开始调用库存微服务..");
            accountService.decrease(order.getUserId(),order.getMoney());
            System.out.println("----->开始调用账户微服务..");
            //将订单状态改成1 支付
            orderDao.updateStatus(userId,1);
        }
    }

}
