package com.neuedu.ssm_shop.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

import org.springframework.web.multipart.MultipartFile;

/**
 * 商品类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3404378730914177964L;
	/**
	 * 商品ID
	 */
	private Integer id;
	/**
	 * 商品名称
	 */
	private String name;
	/**
	 * 商品描述
	 */
	private String descr;
	private double normalprice;
	private double memberprice;
	private Timestamp pdate;
	private Category category;
	/**
	 * 图片相对于服务器的路径
	 * 在实际项目中，会有专门的服务器只存资源
	 */
	private String imgPath;
	
	private MultipartFile file;
	
	private Integer categoryid;


	
}
