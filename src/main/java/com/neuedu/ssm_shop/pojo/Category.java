package com.neuedu.ssm_shop.pojo;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5465458166328518803L;
	private Integer id;
	private String categoryName;
	private String categoryDescription;
	private Integer categoryParentId;
	private Boolean leaf;
	private Integer grade;
	//创建存放递归后结果的容器
	private List<Category> children;
	public Category(String categoryName, String categoryDescription, Integer categoryParentId,int grade) {
		this.categoryName = categoryName;
		this.categoryDescription = categoryDescription;
		this.categoryParentId = categoryParentId;
		this.grade = grade;
	}
	
	
	
}
