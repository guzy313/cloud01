package com.my.springcloud.service.impl;

import com.my.springcloud.dao.StorageDao;
import com.my.springcloud.domain.Storage;
import com.my.springcloud.service.StorageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Gzy
 * @version 1.0
 * @Description
 * @date create on 2023/3/22
 */
@Service
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageDao storageDao;

    @Override
    public List<Storage> findByProductId(Long productId) {
        return storageDao.findByProductId(productId);
    }

    public Storage create() {
        //生成总数
        Integer total = 10000;
        Storage storage = new Storage();
        storage.setId(storageDao.findMaxId() + 1);//查询最大ID实现自增[数据库表主键自增策略会导致seata事务回滚锁表]
        //查询商品ID-生成ID使用(自增)
        List<Storage> list = storageDao.findByProductId(null);
        if(list.size() > 0){
            Long maxProductId = 0L;
            for (Storage a:list) {
                if(maxProductId < a.getProductId()){
                    maxProductId = a.getProductId();
                }
            }
            maxProductId = maxProductId + 1;
            storage.setProductId(maxProductId);
        }else{
            storage.setProductId(1L);
        }
        storage.setTotal(total);
        storage.setUsed(0);
        storage.setResidue(total);
        storageDao.insert(storage);
        return storage;
    }

    @Override
    public void decrease(Long productId, Integer count) {
        storageDao.updateCount(productId,count);
    }

}
