package com.speily.server.search.service.impl;

import com.alibaba.fastjson.JSON;
import com.speily.server.search.dao.ProductDao;
import com.speily.server.search.entity.Product;
import com.speily.server.search.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: SPL
 * @Date: 2019-07-16 10:43
 * @Description: EsSearch接口 实现类
 */
@Service
@Slf4j
public class ProductServiceImpl extends BaseSearchServiceImpl<Product> implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Resource
    private ElasticsearchTemplate elasticsearchTemplate;

    @Override
    public void save(Product ... products) {
        elasticsearchTemplate.putMapping(Product.class);
        if(products.length > 0){
            /*Arrays.asList(productDocuments).parallelStream()
                    .map(productDocumentRepository::save)
                    .forEach(productDocument -> log.info("【保存数据】：{}", JSON.toJSONString(productDocument)));*/
            log.info("【保存索引】：{}", JSON.toJSONString(productDao.saveAll(Arrays.asList(products))));
        }
    }

    @Override
    public void delete(String id) {
        productDao.deleteById(id);
    }

    @Override
    public void deleteAll() {
        productDao.deleteAll();
    }

    @Override
    public Product getById(String id) {
        return productDao.findById(id).get();
    }

    @Override
    public List<Product> getAll() {
        List<Product> list = new ArrayList<>();
        productDao.findAll().forEach(list::add);
        return list;
    }
}
