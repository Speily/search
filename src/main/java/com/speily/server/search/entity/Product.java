package com.speily.server.search.entity;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Mapping;

import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: SPL
 * @Date: 2019-07-16 11:10
 * @Description: -商品实体
 */
@Getter @Setter
@Builder
@Document(indexName = "orders",type = "product")
@Mapping(mappingPath = "/ikJson/productIndex.json") // 解决IK分词不能使用问题
public class Product implements Serializable{

    @Id
    private String id;

    private String productName;

    private String productDesc;

    private Date createTime;

    private Date updateTime;


    @Tolerate
    public Product() {}
}
