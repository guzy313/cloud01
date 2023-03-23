package com.my.springcloud.service;

import com.my.springcloud.dao.OrderDao;
import com.my.springcloud.domain.Order;
import org.apache.ibatis.annotations.Param;
import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

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
public interface OrderService {

     List<Order> findByMap(Map<String,Object> columns);

     Order create(Long userId,Long productId,Integer count, BigDecimal money);

     void update(Long userId,String e);

}
