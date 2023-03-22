package com.my.springcloud.controller;

import com.my.springcloud.domain.Storage;
import com.my.springcloud.entity.CommonResult;
import com.my.springcloud.service.StorageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Gzy
 * @version 1.0
 * @Description
 * @date create on 2023/3/22
 */
@Controller
public class StorageController {
    @Resource
    private StorageService storageService;

    /**
     * 查询商品库存
     * @param productId
     * @return
     */
    @ResponseBody
    @GetMapping("/storage/findByProductId")
    public CommonResult findByProductId(@RequestParam(value = "productId",required = false)Long productId){
        List<Storage> result = storageService.findByProductId(productId);
        System.out.println("查询商品库存成功!");
        return new CommonResult(200,"查询商品库存成功",result);
    }


    /**
     * 新建商品
     * @param productId
     * @param count
     * @return
     */
    @PostMapping(value = "/storage/create")
    public CommonResult create(@RequestParam(value = "productId",required = true)Long productId,
                                 @RequestParam(value = "total",required = true)Integer total){
        storageService.create(productId,total);
        System.out.println("新增商品成功!");
        return new CommonResult(200,"新增商品成功");
    }



    /**
     * 订单支付消耗商品库存
     * @param productId
     * @param count
     * @return
     */
    @PostMapping(value = "/storage/decrease")
    public CommonResult decrease(@RequestParam(value = "productId",required = true)Long productId,
                                 @RequestParam(value = "count",required = true)Integer count){
        storageService.decrease(productId,count);
        System.out.println("消耗商品库存成功!");
        return new CommonResult(200,"消耗商品库存成功");
    }

}
