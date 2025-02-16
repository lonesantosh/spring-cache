package com.service;

import com.model.Product;

public interface IProductService {

 public	Iterable<Product> getAllProduct();
 public String addProduct(Product pp);
 public Product getProductByProductId(int id);
 public String updateEmployee(Product p);
 public String deleteProductByPorudtId(int id);
}
