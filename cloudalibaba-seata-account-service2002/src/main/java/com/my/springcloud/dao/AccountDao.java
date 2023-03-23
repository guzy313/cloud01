package com.my.springcloud.dao;

import com.my.springcloud.domain.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;


/**
 * @author Gzy
 * @version 1.0
 * @Description
 * @date create on 2023/3/21
 */
@Mapper
@Component
public interface AccountDao {


    List<Account> findAll();

    List<Account> findByUserId(@Param("userId")Long userId);

    Long findMaxId();

    void insert(Account account);

    void decrease(@Param("userId") Long userId, @Param("money")BigDecimal money);

}
