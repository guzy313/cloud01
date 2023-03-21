package com.my.springcloud.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;

/**
 * @author Gzy
 * @version 1.0
 * @Description 订单类
 * @date create on 2023/3/20
 */
@TableName("t_order")
public class Order {
    private Long id;

    @TableField(value = "user_id")
    private Long userId;

    @TableField(value = "product_id")
    private Long productId;

    private Integer count;

    private BigDecimal money;

    /* 订单状态 0：创建中 1：已创建*/
    private Integer status;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
