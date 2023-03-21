package com.my.springcloud.controller;

import com.my.springcloud.dao.AccountDao;
import com.my.springcloud.domain.Account;
import com.my.springcloud.entity.CommonResult;
import com.my.springcloud.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author Gzy
 * @version 1.0
 * @Description
 * @date create on 2023/3/21
 */
@Controller
public class AccountController {

    @Resource
    private AccountService accountService;

    @ResponseBody
    @GetMapping("/account/findAll")
    public CommonResult decrease() {
        List<Account> result = accountService.findAll();
        return new CommonResult(200,"查询成功",result);
    }


    @PostMapping("/account/decrease")
    public CommonResult decrease(@RequestParam("userId") Long userId,@RequestParam("money") BigDecimal money) {
        accountService.decrease(userId,money);
        return new CommonResult(200,"消费成功");
    }

}
