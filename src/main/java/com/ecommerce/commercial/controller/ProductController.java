package com.ecommerce.commercial.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.commercial.model.Product;
import com.ecommerce.commercial.service.ProductService;

@RestController
@CrossOrigin
@RequestMapping(value="/products")
public class ProductController {

  @Autowired
  private ProductService productService;
  
@GetMapping
  public List<Product> getAllProducts() {
    return productService.getAllProducts();
  }

@GetMapping("{id}")
  public Product getProductById(@PathVariable(name="id") Long id) {
    return productService.getProductById(id);
  }

@PostMapping
  public void createProduct(@RequestBody Product product) {
    productService.createProduct(product);
  }

@PutMapping("{id}")
  public void updateProduct(@PathVariable(name="id") Long id, @RequestBody Product product) {
    productService.updateProduct(id, product);
  }

@DeleteMapping("{id}")
  public void deleteProduct(@PathVariable(name="id") Long id) {
    productService.deleteProduct(id);
}
}