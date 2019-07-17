package com.speily.server.search.service;

import com.speily.server.search.entity.Product;

import java.util.List;

/**
 * @Auther: SPL
 * @Date: 2019-07-16 10:43
 * @Description: EsSearch接口
 * @
 */
public interface ProductService extends BaseSearchService<Product>{

    /**
     * 保存
     * @param product
     */
    void save(Product... product);

    /**
     * 删除
     * @param id
     */
    void delete(String id);

    /**
     * 清空索引
     */
    void deleteAll();

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    Product getById(String id);

    /**
     * 查询全部
     * @return
     */
    List<Product> getAll();
}
