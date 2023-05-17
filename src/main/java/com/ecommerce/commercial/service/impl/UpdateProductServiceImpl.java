package com.ecommerce.commercial.service.impl;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.commercial.model.PutDiscount;
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

      // For loop iteration to access to getPercentage() in PutDiscount
      if (updateProduct.getPutDiscount() != null) {
        for (PutDiscount putDiscount : updateProduct.getPutDiscount()) {
          if (putDiscount.getPercentage() != null) {
            Long percentage = putDiscount.getPercentage();
            Long price = updateProduct.getPrice();
            Long discountAmount = (price * percentage) / 100;
            updatedProduct.setDiscountedPrice(price - discountAmount);
            break; 
          }
        }

      //With period constraint
      // if (updateProduct.getPutDiscount() != null) {
      //   LocalDate currentDate = LocalDate.now();
      //   for (PutDiscount putDiscount : updateProduct.getPutDiscount()) {
      //     LocalDate startDate = putDiscount.getStartDate();
      //     LocalDate endDate = putDiscount.getEndDate();
      //     if (startDate != null && endDate != null && currentDate.compareTo(startDate) >=0  && currentDate.compareTo(endDate) <=0) {
      //       if (putDiscount.getPercentage() != null) {
      //       Long percentage = putDiscount.getPercentage();
      //       Long price = updateProduct.getPrice();
      //       Long discountAmount = (price * percentage) / 100;
      //       updatedProduct.setDiscountedPrice(price - discountAmount);
      //       break; 
      //       }
      //     }
      //   }
      }
      
        
      updateProductRepository.save(updatedProduct);
    }
  }
}