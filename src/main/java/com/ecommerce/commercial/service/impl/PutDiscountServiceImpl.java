package com.ecommerce.commercial.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.commercial.model.PutDiscount;
import com.ecommerce.commercial.repository.PutDiscountRepository;
import com.ecommerce.commercial.service.PutDiscountService;

@Service
public class PutDiscountServiceImpl implements PutDiscountService{

  @Autowired
  private PutDiscountRepository putDiscountRepository;

    @Override
    public PutDiscount savePutDiscount(PutDiscount putDiscount) {
        return putDiscountRepository.save(putDiscount);
    }

    @Override
    public PutDiscount getPutDiscountById(Long id) {
      return putDiscountRepository.findById(id).orElse(null);
    }

}
