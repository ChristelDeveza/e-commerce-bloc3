package com.ecommerce.commercial.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.commercial.model.Discount;
import com.ecommerce.commercial.repository.DiscountRepository;
import com.ecommerce.commercial.service.DiscountService;

@Service
public class DiscountServiceImpl implements DiscountService {
  
  @Autowired
  private DiscountRepository discountRepository;
  
  @Override
  public List<Discount> getAllDiscount() {
   return discountRepository.findAll();
  }
}
