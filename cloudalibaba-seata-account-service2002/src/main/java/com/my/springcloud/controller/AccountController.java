package com.my.springcloud.controller;

import com.my.springcloud.dao.AccountDao;
import com.my.springcloud.domain.Account;
import com.my.springcloud.entity.CommonResult;
import com.my.springcloud.service.AccountService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author Gzy
 * @version 1.0
 * @Description
 * @date create on 2023/3/21
 */
@RestController
public class AccountController {

    @Resource
    private AccountService accountService;

    @GetMapping("/account/findAll")
    public CommonResult findAll() {
        List<Account> result = accountService.findAll();
        return new CommonResult(200,"查询成功",result);
    }

    /**
     * 创建用户 （用户ID自增）
     * @return
     */
    @GetMapping("/account/create")
    public CommonResult create() {
        Account account = accountService.create();
        System.out.println("创建用户成功");
        return new CommonResult(200,"创建用户成功",account);
    }



    @PostMapping("/account/decrease")
    public CommonResult decrease(@RequestParam("userId") Long userId,@RequestParam("money") BigDecimal money) {
        accountService.decrease(userId,money);
        System.out.println("消费成功");
        return new CommonResult(200,"消费成功");
    }

}
