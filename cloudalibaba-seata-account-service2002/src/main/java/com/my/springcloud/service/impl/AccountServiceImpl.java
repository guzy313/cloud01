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
    public Account create() {
        Account account = new Account();
        account.setId(accountDao.findMaxId() + 1);
        int total = 10000;
        account.setTotal(total);
        account.setResidue(total);
        account.setUsed(0);
        //查询用户ID-生成ID使用(自增)
        List<Account> list = accountDao.findAll();
        if(list.size() > 0){
            Long maxUserId = 0L;
            for (Account a:list) {
                if(maxUserId < a.getUserId()){
                    maxUserId = a.getUserId();
                }
            }
            maxUserId = maxUserId + 1;
            account.setUserId(maxUserId);
        }else{
            account.setUserId(1L);
        }
        accountDao.insert(account);
        return account;
    }

    @Override
    public void decrease(Long userId, BigDecimal money) {
        accountDao.decrease(userId,money);
    }
}
