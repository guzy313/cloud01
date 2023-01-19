package com.my.springcloud.service.impl;

import com.my.springcloud.service.OrderService;
import org.springframework.stereotype.Service;

/**
 * @author Gzy
 * @version 1.0
 * @Description
 * @date create on 2023/1/19
 */
@Service
public class OrderServiceFallback implements OrderService {


    @Override
    public String paymentInfo_OK(Integer id) {
        return "单独备用方法:" + id;
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "单独备用方法:" + id;
    }
}
