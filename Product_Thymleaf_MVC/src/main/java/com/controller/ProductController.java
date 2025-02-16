package com.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.model.Product;
import com.service.IProductService;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private IProductService service;
	
	@GetMapping("/")
	public String homePage() {
		return "home";
	}
	
	@GetMapping("/get")
 public String showAllproduct(Map<String, Object> map) {
	 
	 Iterable<Product> pp=service.getAllProduct();
	 
	 map.put("productData", pp);
	 return "product_data";
 }
	
	@GetMapping("/add")
	public String addProduct(@ModelAttribute("pp") Product product) {
		
		return "addProduct";
	}
	
	@PostMapping("/add")
	public String insertProductData(RedirectAttributes att,@ModelAttribute("pp") Product product) {
		
		String ResultMsg=service.addProduct(product);
		att.addFlashAttribute(ResultMsg, att);
		return "redirect:get";
		
	}
	
	@GetMapping("/edit")
	public String showEditProdut(@RequestParam("no") int no, @ModelAttribute("product") Product product) {
		
		Product pp1=service.getProductByProductId(no);
		BeanUtils.copyProperties(pp1, product);
		return ("edit_product");
		
	}
	
	@PostMapping("/edit")
	public String editProduct(RedirectAttributes att,@ModelAttribute("pp") Product product, @RequestParam("no") int no) {
		
		String result=service.updateEmployee(product);
		att.addFlashAttribute(result, att);
		return "redirect:get";
	}
	
	@GetMapping("/delete")
	public String deleteProduct(@RequestParam("no") int no,RedirectAttributes att) {
	
		String result=service.deleteProductByPorudtId(no);
		att.addFlashAttribute(result, att);
		return "redirect:get";
	}
	
	
	
	
}
