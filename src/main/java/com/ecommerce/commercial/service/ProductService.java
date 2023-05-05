package com.ecommerce.commercial.service;

import java.util.List;

import com.ecommerce.commercial.model.Product;

public interface ProductService {
  List<Product> getAllProducts();

  void createProduct(Product product);
  void updateProduct(Long id, Product product);
  
}
