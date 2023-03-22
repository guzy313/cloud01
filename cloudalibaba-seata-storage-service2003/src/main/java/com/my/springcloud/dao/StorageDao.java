package com.my.springcloud.dao;

import com.my.springcloud.domain.Storage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Gzy
 * @version 1.0
 * @Description
 * @date create on 2023/3/22
 */
@Mapper
@Component
public interface StorageDao {

    List<Storage> findByProductId(@Param("productId") Long productId);

    void insert(Storage storage);

    void updateCount(@Param("productId") Long productId, @Param("count") Integer count);

}
