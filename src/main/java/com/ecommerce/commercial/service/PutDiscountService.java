package com.ecommerce.commercial.service;

import java.util.List;

import com.ecommerce.commercial.model.PutDiscount;

public interface PutDiscountService {
  PutDiscount savePutDiscount(PutDiscount putDiscount);
  PutDiscount getPutDiscountById(Long id);
  List<PutDiscount> getAllDiscounts();

}
