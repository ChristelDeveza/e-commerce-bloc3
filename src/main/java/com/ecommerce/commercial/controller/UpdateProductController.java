package com.ecommerce.commercial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.commercial.model.UpdateProduct;
import com.ecommerce.commercial.service.UpdateProductService;

@RestController
@CrossOrigin
@RequestMapping(value="/update")
public class UpdateProductController {
  
@Autowired
private UpdateProductService updateProductService;

  
@PutMapping("{id}")
public void updateProduct(@PathVariable(name="id") Long id, @RequestBody UpdateProduct updateProduct) {
  updateProductService.updateProduct(id, updateProduct);
}
}