package com.my.springcloud.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author Gzy
 * @version 1.0
 * @Description: 支付类
 */
@Component
public class Payment implements Serializable{

    //主键
    private Long id;

    //流水号
    private String serial;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }
}
