package com.my.springcloud.service;

import com.my.springcloud.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author Gzy
 * @version 1.0
 * @Description 远程调用账户服务
 * @date create on 2023/3/20
 */

@FeignClient(value = "cloudalibaba-seata-account-service")
@Service
public interface AccountService {

    //扣账户余额
    @PostMapping(value = "/account/decrease")
    CommonResult decrease(@RequestParam("userId")Long userId,
                      @RequestParam("money")BigDecimal money);

}
