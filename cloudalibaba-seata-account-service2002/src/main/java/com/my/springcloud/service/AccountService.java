package com.my.springcloud.service;

import com.my.springcloud.domain.Account;
import com.my.springcloud.entity.CommonResult;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Gzy
 * @version 1.0
 * @Description
 * @date create on 2023/3/21
 */
public interface AccountService {

    List<Account> findAll();

    Account create();

    void decrease(Long userId,BigDecimal money);

}
