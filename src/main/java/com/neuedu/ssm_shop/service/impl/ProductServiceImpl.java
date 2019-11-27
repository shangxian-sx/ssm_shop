package com.neuedu.ssm_shop.service.impl;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.neuedu.ssm_shop.common.CommonUtil;
import com.neuedu.ssm_shop.mapper.CategoryMapper;
import com.neuedu.ssm_shop.mapper.ProductMapper;
import com.neuedu.ssm_shop.pojo.Category;
import com.neuedu.ssm_shop.pojo.Product;
import com.neuedu.ssm_shop.pojo.ProductConditionVO;
import com.neuedu.ssm_shop.service.ProductService;
@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductMapper mapper;
	@Autowired
	private CategoryMapper cmapper;


	public List<Product> findAll() {
		return mapper.findAll();
	}


	public Product findById(Integer id) {
		return null;
	}

	
	public void insert(Product product,CommonsMultipartFile file, HttpServletRequest request) {
		try {
			String path = request.getServletContext().getRealPath("/") + "/images/"
					+ UUID.randomUUID().toString().replace("-", "") + file.getOriginalFilename();
			//创建文件
			File f = new File(path);
			//判断path下的文件夹是否有
			File fileParent = f.getParentFile(); 
			//如果不存在
			if(!fileParent.exists()){ 
				//创建该路径下的文件夹
				fileParent.mkdirs(); 
			} 
			
			try {
				//上传
				file.transferTo(f);
			}catch (Exception e) {
				e.printStackTrace();
			}
			// 保存数据库的路径
			String imgPath = null;
			// 把图片的相对路径保存至数据库
			imgPath = "/images" + path.substring(path.lastIndexOf("/"));
			product.setImgPath(imgPath);  
			mapper.insert(product);
			//存到Eclipse路径下-->文件拷贝
			//...
			CommonUtil.fileCopyToLocal(path, 
					"E:\\soft\\eclipse-jee-2019-06\\work——zuoye\\ssm_shop\\img"+imgPath);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		

	}

	
	public void delete(Integer id) {
		mapper.delete(id);

	}

	
	public void update(Product product) {
		// TODO Auto-generated method stub

	}

	
	public List<Product> findByCondition(ProductConditionVO productCondition) {
		//1.
		//2.
		//3.
		return mapper.findByCondition(productCondition);
	}
	/**
	 * redisCacheManager ：配置文件中缓存管理器
	 * 'lastProduct'：存放到redis中的key
	 */
	
	@Cacheable(value="redisCacheManager",key="'lastProduct'")
	public List<Product> lastProduct(Integer pageNo){
		System.out.println("没有存放到缓存中");
		return mapper.lastProduct(pageNo);
	}

	
	public List<Product> recommendedProduct(Category category) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<Category> findThree() {
		
		return cmapper.findThree();
	}

}
