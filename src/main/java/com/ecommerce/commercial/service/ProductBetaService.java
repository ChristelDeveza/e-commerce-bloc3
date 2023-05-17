package com.ecommerce.commercial.service;

import java.util.List;

import com.ecommerce.commercial.model.DiscountBeta;
import com.ecommerce.commercial.model.ProductBeta;


public interface ProductBetaService {
  ProductBeta getProductById(Long productId);
  List<ProductBeta> getAllProducts();
  ProductBeta saveProduct(ProductBeta productBeta);
  void deleteProduct(Long productId);
  DiscountBeta getDiscountById(Long discountId);
  List<DiscountBeta> getAllDiscounts();
  void applyDiscountToProduct(Long productId, Long discountId);
}


