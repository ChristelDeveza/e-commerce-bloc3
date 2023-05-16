package com.ecommerce.commercial.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.commercial.model.UpdateProduct;
import com.ecommerce.commercial.repository.UpdateProductRepository;
import com.ecommerce.commercial.service.UpdateProductService;

@Service
public class UpdateProductServiceImpl implements UpdateProductService{
  @Autowired
  private UpdateProductRepository updateProductRepository;

  @Override
  public void updateProduct(Long id, UpdateProduct updateProduct) {
    Optional<UpdateProduct> existingProduct = updateProductRepository.findById(id);
    if(existingProduct.isPresent()) {
      UpdateProduct updatedProduct = existingProduct.get();
      if(updateProduct.getName() != null){
        updatedProduct.setName(updateProduct.getName());
      }
      if(updateProduct.getPrice() != null) {
        updatedProduct.setPrice(updateProduct.getPrice());
      }

      if(updateProduct.getDescription() != null) {
        updatedProduct.setDescription(updateProduct.getDescription());
      }

      if(updateProduct.getCategoryId() != null) {
        updatedProduct.setCategoryId(updateProduct.getCategoryId());
      }

      if(updateProduct.getDiscountId() != null) {
        updatedProduct.setDiscountId(updateProduct.getDiscountId());
      }

      if(updateProduct.getDiscountedPrice() != null) {
        updatedProduct.setDiscountedPrice(updateProduct.getDiscountedPrice());
      }

     
      updateProductRepository.save(updatedProduct);
    }
  }
}
