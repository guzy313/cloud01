package com.my.springcloud.service;

import com.my.springcloud.entity.Payment;

import java.util.List;

/**
 * @author Gzy
 * @version 1.0
 * @Description 支付接口
 */
public interface PaymentService {

    public int add(Payment payment);

    int delete(Long id);

    int update(Payment payment);

    List<Payment> findList();

    Payment findById(Long id);

}
