package com.ecommerce.commercial.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.commercial.model.Product;
import com.ecommerce.commercial.repository.ProductRepository;
import com.ecommerce.commercial.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

  @Autowired
  private ProductRepository productRepository;

  private static List<Product> maListe = new ArrayList<>();

  @Override
  public List<Product> getAllProducts() {
   return productRepository.findAll();
  }

  @Override
  public Product getProductById(Long id) {
    Optional<Product> productId = productRepository.findById(id);
    return productId.orElse(null);
  }

  @Override
  public void createProduct(Product product) {
    productRepository.save(product);
  }

  @Override
  public void updateProduct(Long id, Product product) {
    Optional<Product> existingProduct = productRepository.findById(id);
    if(existingProduct.isPresent()) {
      Product updatedProduct = existingProduct.get();
      if(product.getName() != null){
        updatedProduct.setName(product.getName());
      }
      if(product.getPrice() != null) {
        updatedProduct.setPrice(product.getPrice());
      }
      productRepository.save(updatedProduct);
    }
  }

  @Override
  public void deleteProduct(Long id) {
    productRepository.deleteById(id);
  }
  
}
