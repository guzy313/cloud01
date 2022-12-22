package com.my.springcloud.service;

import com.my.springcloud.dao.PaymentMapper;
import com.my.springcloud.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
