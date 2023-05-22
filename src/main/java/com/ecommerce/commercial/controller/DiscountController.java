package com.ecommerce.commercial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.commercial.config.JwtConfig;
import com.ecommerce.commercial.model.Discount;
import com.ecommerce.commercial.service.DiscountService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
@RequestMapping(value="/discounts")
public class DiscountController {
   
  @Autowired
  private DiscountService discountService;

  @GetMapping
  public ResponseEntity<List<Discount>> getAllDiscount(HttpServletRequest request) {
    String jwt = request.getHeader("Authorization");
    
    if (jwt == null || jwt.isEmpty()) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
    }
    String newJwt = jwt.replace("Bearer ", "");
    System.out.print(newJwt);
    if (JwtConfig.validateJwt(newJwt)) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
    }

    List<Discount> discounts = discountService.getAllDiscount();
    return ResponseEntity.ok(discounts);
  }
}
