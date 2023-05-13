package com.ecommerce.commercial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.commercial.model.PostProduct;
import com.ecommerce.commercial.service.PostProductService;

@RestController
@CrossOrigin
@RequestMapping(value="/create")
public class PostProductController {

  @Autowired
  private PostProductService postProductService;
  
@PostMapping
public void createProduct(@RequestBody PostProduct postProduct) {
  postProductService.createProduct(postProduct);
}
}
