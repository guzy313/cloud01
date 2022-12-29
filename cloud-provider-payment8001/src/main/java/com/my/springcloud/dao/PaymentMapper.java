package com.my.springcloud.dao;

import com.my.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Gzy
 * @version 1.0
 * @Description
 */
@Mapper
@Component
public interface PaymentMapper {

    int add(Payment payment);

    int delete(Long id);

    int update(Payment payment);

    List<Payment> findList();

    Payment findById(Long id);

}
