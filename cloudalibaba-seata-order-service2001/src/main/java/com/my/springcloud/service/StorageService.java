package com.my.springcloud.service;

import com.my.springcloud.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Gzy
 * @version 1.0
 * @Description 库存服务远程调用
 * @date create on 2023/3/20
 */
@FeignClient(value = "cloudalibaba-seata-storage-service")
@Service
public interface StorageService {

    //减商品库存
    @PostMapping(value = "/storage/decrease")
    CommonResult decrease(@RequestParam("productId")Long productId,
                          @RequestParam("count")Integer count,
                          @RequestParam(value = "e",required = false)String e);

}
