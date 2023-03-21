package com.my.springcloud.service.impl;

import com.my.springcloud.dao.OrderDao;
import com.my.springcloud.domain.Order;
import com.my.springcloud.service.AccountService;
import com.my.springcloud.service.OrderService;
import com.my.springcloud.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
        return orderDao.selectByMap(columns);
    }

    @Override
    public void create(Order order){
        order.setStatus(0);
        System.out.println("订单开始创建..");

        orderDao.insert(order);
        System.out.println("----->开始调用订单微服务..");
        storageService.decrease(order.getProductId(),order.getCount());
        System.out.println("----->开始调用库存微服务..");
        accountService.decrease(order.getUserId(),order.getMoney());
        System.out.println("----->开始调用账户微服务..");
    }

    @Override
    public void update(Long userId){
        //将订单状态改成1 支付
        orderDao.updateStatus(userId,1);
    }

}
