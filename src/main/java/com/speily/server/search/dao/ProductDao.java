package com.speily.server.search.dao;

import com.speily.server.search.entity.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

/**
 * @Auther: SPL
 * @Date: 2019-07-16 11:15
 * @Description: -dao 接口 对接：ElasticsearchRepository
 */
@Component
public interface ProductDao extends ElasticsearchRepository<Product,String> {
}
