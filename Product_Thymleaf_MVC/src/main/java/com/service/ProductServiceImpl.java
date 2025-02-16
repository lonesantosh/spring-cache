package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Product;
import com.repo.ProductRepo;

@Service("ProductService")
public class ProductServiceImpl implements IProductService {

	@Autowired
	private ProductRepo repo;
	
	@Override
	public String addProduct(Product pp) {
		
		return "Product is saved "+repo.save(pp);
	}
	
	@Override
	public Iterable<Product> getAllProduct() {
		
		return repo.findAll();
	}
	
	@Override
	public Product getProductByProductId(int id) {
		Product obj=repo.findById(id).get();
		return obj;
	}
	@Override
	public String updateEmployee(Product p) {
		int id=repo.save(p).getProductId();
		return id+" is updated";
	}
	@Override
	public String deleteProductByPorudtId(int id) {
		repo.deleteById(id);
		return id+" is deleted";
	}
}
