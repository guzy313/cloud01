package com.my.springcloud.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.my.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @author Gzy
 * @version 1.0
 * @Description
 * @date create on 2023/3/20
 */
@Mapper
@Component
public interface OrderDao extends BaseMapper<Order> {

    void updateStatus(@Param("userId")Long userId,@Param("status")Integer status);

}
