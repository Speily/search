package com.speily.server.search;

import com.alibaba.fastjson.JSON;
import com.speily.server.search.entity.Product;
import com.speily.server.search.page.Page;
import com.speily.server.search.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SearchApplicationTests {

	@Autowired
	private ProductService esSearchService;

	@Test
	public void save() {
		log.info("【创建索引前的数据条数】：{}",esSearchService.getAll().size());

		Product productDocument = Product.builder()
				.id(System.currentTimeMillis() + "01")
				.productName("无印良品 MUJI 基础润肤化妆水")
				.productDesc("无印良品 MUJI 基础润肤化妆水 高保湿型 200ml")
				.createTime(new Date())
				.updateTime(new Date())
				.build();

		Product productDocument1 = Product.builder()
				.id(System.currentTimeMillis() + "02")
				.productName("荣耀 V10 尊享版")
				.productDesc("荣耀 V10 尊享版 6GB+128GB 幻夜黑 移动联通电信4G全面屏游戏手机 双卡双待")
				.createTime(new Date()).updateTime(new Date())
				.build();

		Product productDocument2 = Product.builder()
				.id(System.currentTimeMillis() + "03")
				.productName("资生堂(SHISEIDO) 尿素红罐护手霜")
				.productDesc("日本进口 资生堂(SHISEIDO) 尿素红罐护手霜 100g/罐 男女通用 深层滋养 改善粗糙")
				.createTime(new Date()).updateTime(new Date())
				.build();

		esSearchService.save(productDocument,productDocument1,productDocument2);

		log.info("【创建索引ID】:{},{},{}",productDocument.getId(),productDocument1.getId(),productDocument2.getId());
		log.info("【创建索引后的数据条数】：{}",esSearchService.getAll().size());
	}

	@Test
	public void getAll(){
		esSearchService.getAll().parallelStream()
				.map(JSON::toJSONString)
				.forEach(System.out::println);
	}

	@Test
	public void deleteAll() {
		esSearchService.deleteAll();
	}

	@Test
	public void getById() {
		log.info("【根据ID查询内容】：{}", JSON.toJSONString(esSearchService.getById("154470178213401")));
	}

	@Test
	public void query() {
		log.info("【根据关键字搜索内容】：{}", JSON.toJSONString(esSearchService.query("无印良品荣耀",Product.class)));
	}

	@Test
	public void queryHit() {

		String keyword = "联通尿素";
		String indexName = "orders";

		List<Map<String,Object>> searchHits = esSearchService.queryHit(keyword,indexName,"productName","productDesc");
		log.info("【根据关键字：’{}‘ 搜索内容，命中部分高亮，返回内容】：{}", keyword, JSON.toJSONString(searchHits));
	}

	@Test
	public void queryHitByPage() {

		String keyword = "联通尿素";
		String indexName = "orders";

		Page<Map<String,Object>> searchHits = esSearchService.queryHitByPage(1,1,keyword,indexName,"productName","productDesc");
		log.info("【分页查询，根据关键字：'{}' 搜索内容，命中部分高亮，返回内容】：{}", keyword, JSON.toJSONString(searchHits));
	}

	@Test
	public void deleteIndex() {
		log.info("【删除索引库】");
		esSearchService.deleteIndex("orders");
	}

}
