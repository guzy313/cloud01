package com.my.springcloud.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;

/**
 * @author Gzy
 * @version 1.0
 * @Description
 * @date create on 2023/3/22
 */
@TableName("t_storage")
public class Storage {
    private Long id;

    //商品ID
    @TableField(value = "product_id")
    private Long productId;

    //库存总量
    private Integer total;

    //已消耗库存
    private Integer used;

    //剩余库存
    private Integer residue;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getUsed() {
        return used;
    }

    public void setUsed(Integer used) {
        this.used = used;
    }

    public Integer getResidue() {
        return residue;
    }

    public void setResidue(Integer residue) {
        this.residue = residue;
    }
}
