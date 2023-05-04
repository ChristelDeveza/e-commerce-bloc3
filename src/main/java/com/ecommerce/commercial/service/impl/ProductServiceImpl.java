package com.ecommerce.commercial.service.impl;

import java.util.ArrayList;
import java.util.List;

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
  
}
