package com.ecommerce.commercial.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.commercial.model.Product;
import com.ecommerce.commercial.service.ProductService;

@RestController
@RequestMapping(value="/products")
public class ProductController {

  @Autowired
  private ProductService productService;
  
@GetMapping
  public List<Product> getAllProducts() {
    // List<Product>allProducts = productService.getAllProducts();
    return productService.getAllProducts();
  }
}
