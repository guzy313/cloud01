package com.my.springcloud.service.impl;

import com.my.springcloud.dao.PaymentMapper;
import com.my.springcloud.entity.Payment;
import com.my.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Gzy
 * @version 1.0
 * @Description: 支付服务层实现
 */
@Service
public class PaymentServiceImpl implements PaymentService {


    @Autowired
    private PaymentMapper paymentMapper;


    @Override
    public int add(Payment payment){
        int add = paymentMapper.add(payment);
        return add;
    }

    @Override
    public int delete(Long id) {
        return paymentMapper.delete(id);
    }

    @Override
    public int update(Payment payment) {
        return paymentMapper.update(payment);
    }

    @Override
    public List<Payment> findList() {
        return paymentMapper.findList();
    }

    @Override
    public Payment findById(Long id) {
        return paymentMapper.findById(id);
    }

}
