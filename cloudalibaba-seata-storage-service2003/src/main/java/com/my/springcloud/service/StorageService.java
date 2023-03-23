package com.my.springcloud.service;

import com.my.springcloud.domain.Storage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Gzy
 * @version 1.0
 * @Description
 * @date create on 2023/3/22
 */
public interface StorageService {

    List<Storage> findByProductId(@Param("productId") Long productId);

    Storage create();

    void decrease(Long productId,Integer count);

}
