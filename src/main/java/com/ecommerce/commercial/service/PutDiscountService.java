package com.ecommerce.commercial.service;

import com.ecommerce.commercial.model.PutDiscount;

public interface PutDiscountService {
  PutDiscount savePutDiscount(PutDiscount putDiscount);
  PutDiscount getPutDiscountById(Long id);
}
