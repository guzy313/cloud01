package com.my.springcloud.dao;

import com.my.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Gzy
 * @version 1.0
 * @Description
 */
@Mapper
public interface paymentMapper {

    int add(Payment payment);

    int del(Long id);

    int update(Payment payment);

    List<Payment> select();

    Payment selectById(Long id);

}
