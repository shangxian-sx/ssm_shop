package com.neuedu.ssm_shop.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.neuedu.ssm_shop.pojo.Category;
import com.neuedu.ssm_shop.pojo.Product;
import com.neuedu.ssm_shop.pojo.ProductConditionVO;



@Repository
public interface ProductMapper {
	List<Product> findAll();
	
	Product findById(Integer id);
	
	void insert(Product product);
	
	void delete(Integer id);
	
	void update(Product product);
	
	List<Product> findByCondition(ProductConditionVO productCondition);
	
	/**
	 * 最新商品
	 */
	List<Product> lastProduct(Integer pageNo);
	
	/**
	 * 推荐商品（猜你喜欢）
	 */
	List<Product> recommendedProduct(Category category);
}
