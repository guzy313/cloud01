package com.my.springcloud.controller;

import com.my.springcloud.domain.Storage;
import com.my.springcloud.entity.CommonResult;
import com.my.springcloud.service.StorageService;
import io.netty.util.internal.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Gzy
 * @version 1.0
 * @Description
 * @date create on 2023/3/22
 */
@RestController
public class StorageController {
    @Resource
    private StorageService storageService;

    /**
     * 查询商品库存
     * @param productId
     * @return
     */
    @GetMapping("/storage/findByProductId")
    public CommonResult findByProductId(@RequestParam(value = "productId",required = false)Long productId){
        List<Storage> result = storageService.findByProductId(productId);
        System.out.println("查询商品库存成功!");
        return new CommonResult(200,"查询商品库存成功",result);
    }


    /**
     * 新建商品
     * @return
     */
    @GetMapping(value = "/storage/create")
    public CommonResult create(){
        Storage storage = storageService.create();
        System.out.println("新增商品成功!");
        return new CommonResult(200,"新增商品成功",storage);
    }



    /**
     * 订单支付消耗商品库存
     * @param productId
     * @param count
     * @return
     */
    @PostMapping(value = "/storage/decrease")
    public CommonResult decrease(@RequestParam(value = "productId",required = true)Long productId,
                                 @RequestParam(value = "count",required = true)Integer count,
                                 @RequestParam(value = "e",required = false)String e){
        if(!StringUtil.isNullOrEmpty(e) && "1".equals(e)){
            throw new RuntimeException("测试库存事务回滚异常");
        }
        storageService.decrease(productId,count);
        System.out.println("消耗商品库存成功!");
        return new CommonResult(200,"消耗商品库存成功");
    }

}
