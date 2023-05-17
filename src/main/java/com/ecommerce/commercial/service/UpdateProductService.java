package com.ecommerce.commercial.service;

// import com.ecommerce.commercial.model.PutDiscount;
import com.ecommerce.commercial.model.UpdateProduct;

public interface UpdateProductService {
  void updateProduct(Long id, UpdateProduct updateProduct);

  // void addDiscountToProduct(Long id, PutDiscount putDiscount);

}
