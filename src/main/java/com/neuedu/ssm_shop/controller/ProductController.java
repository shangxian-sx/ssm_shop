package com.neuedu.ssm_shop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.neuedu.ssm_shop.pojo.Category;
import com.neuedu.ssm_shop.pojo.Product;
import com.neuedu.ssm_shop.pojo.ProductConditionVO;
import com.neuedu.ssm_shop.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService service;

	@RequestMapping("/findByCondition.product")
	public String findByCondition(ProductConditionVO pvo, ModelMap map) {
		System.out.println(pvo);
		List<Product> products = service.findByCondition(pvo);
		map.addAttribute("products", products);
		return "findAll.product";
	}

	@RequestMapping("/findAll.product")
	public String findAll(ModelMap map) {
		System.out.println("===================");
		List<Product> products = service.findAll();
		 map.addAttribute("products", products); 
		 System.out.println(products); 

		return "product_list.jsp";
	}

	@RequestMapping("/insert.product")
	public String insert(Product product, @RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) {
		service.insert(product, file, request);
		return "redirect:findAll.product";
	}

	@RequestMapping("/delete.product")
	public String insert(Integer id) {
		service.delete(id);
		return "redirect:findAll.product";
	}

	@ResponseBody
	@RequestMapping("/findThree.product")
	public List<Category> findThree() {
		return service.findThree();
	}
}
