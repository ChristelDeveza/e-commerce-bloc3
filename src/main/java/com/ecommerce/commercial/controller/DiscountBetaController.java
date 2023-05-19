package com.ecommerce.commercial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.commercial.model.DiscountBeta;
import com.ecommerce.commercial.service.DiscountBetaService;

@RestController
@CrossOrigin
@RequestMapping("alldiscounts")
public class DiscountBetaController {
   
  @Autowired
  private DiscountBetaService discountBetaService;

  //Pb de serialisation
  @GetMapping
  public ResponseEntity<List<DiscountBeta>> getAllDiscounts() {
      List<DiscountBeta> discounts = discountBetaService.getAllDiscounts();
      return ResponseEntity.ok(discounts);
  }
}
