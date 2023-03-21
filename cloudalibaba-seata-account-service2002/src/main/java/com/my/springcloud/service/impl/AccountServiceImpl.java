package com.my.springcloud.service.impl;

import com.my.springcloud.dao.AccountDao;
import com.my.springcloud.domain.Account;
import com.my.springcloud.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author Gzy
 * @version 1.0
 * @Description
 * @date create on 2023/3/21
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountDao accountDao;

    @Override
    public List<Account> findAll() {
        return accountDao.findAll();
    }

    @Override
    public void create(Account account) {
        accountDao.insert(account);
    }

    @Override
    public void decrease(Long userId, BigDecimal money) {
        accountDao.decrease(userId,money);
    }
}
