package com.ecommerce.commercial.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.commercial.model.PostProduct;
import com.ecommerce.commercial.repository.PostProductRepository;
import com.ecommerce.commercial.service.PostProductService;

@Service
public class PostProductServiceImpl implements PostProductService {
  
  @Autowired
  private PostProductRepository postProductRepository;

  @Override
  public PostProduct createProduct(PostProduct postProduct) {
    return postProductRepository.save(postProduct);
  }
}

