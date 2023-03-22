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

    @Override
    public void create(Long productId, Integer total) {
        Storage storage = new Storage();
        storage.setProductId(productId);
        storage.setTotal(total);
        storage.setUsed(0);
        storage.setResidue(total);
        storageDao.insert(storage);
    }

    @Override
    public void decrease(Long productId, Integer count) {
        storageDao.updateCount(productId,count);
    }

}
