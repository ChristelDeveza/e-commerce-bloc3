package com.ecommerce.commercial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.commercial.model.Discount;
import com.ecommerce.commercial.service.DiscountService;

@RestController
@CrossOrigin
@RequestMapping(value="/discounts")
public class DiscountController {
   
  @Autowired
  private DiscountService discountService;

  @GetMapping
  public List<Discount> getAllDiscount() {
    return discountService.getAllDiscount();
  }
}
