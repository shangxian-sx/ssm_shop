package com.neuedu.ssm_shop.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.neuedu.ssm_shop.pojo.Category;
import com.neuedu.ssm_shop.pojo.Product;
import com.neuedu.ssm_shop.pojo.ProductConditionVO;



public interface ProductService {
	List<Product> findAll();
	
	Product findById(Integer id);
	
	void insert(Product product,CommonsMultipartFile file, HttpServletRequest request);
	
	void delete(Integer id);
	
	void update(Product product);
	
/*	
	*//**
	 * 按商品名称查询
	 *//*
	List<Product> findByProductName(String keywords);
	
	*//**
	 * 按商品类别查询
	 *//*
	List<Product> findByProductCid(Category category);
	
	*//**
	 * 按商品类别查询
	 *//*
	List<Product> findByProductPdate(String startDate,String endDate);
	
	*//**
	 * 按商品类别查询（重载）
	 *//*
	List<Product> findByProductPdate(Timestamp startDate,Timestamp endDate);
	
	*//**
	 * 按商品价格查询
	 *//*
	List<Product> findByProductPrice(Double lowPrice,Double highPrice);*/
	
	
	/**
	 * 根据条件查询
	 * @param productCondition
	 * @return
	 */
	List<Product> findByCondition(ProductConditionVO productCondition);
	
	/**
	 * 最新商品
	 */
	List<Product> lastProduct(Integer pageNo);
	
	/**
	 * 推荐商品（猜你喜欢）
	 */
	List<Product> recommendedProduct(Category category);
	
	List<Category> findThree();
}
