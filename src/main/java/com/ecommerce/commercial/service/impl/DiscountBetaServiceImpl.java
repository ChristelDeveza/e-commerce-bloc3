package com.ecommerce.commercial.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.commercial.model.DiscountBeta;
import com.ecommerce.commercial.repository.DiscountBetaRepository;
import com.ecommerce.commercial.service.DiscountBetaService;

@Service
public class DiscountBetaServiceImpl implements DiscountBetaService {

  @Autowired
  private DiscountBetaRepository discountBetaRepository;
  
  @Override
  public List<DiscountBeta> getAllDiscounts() {
   return discountBetaRepository.findAll();
  }
  
}
