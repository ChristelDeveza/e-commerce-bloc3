package com.ecommerce.commercial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.commercial.model.PutDiscount;
import com.ecommerce.commercial.service.PutDiscountService;

@RestController
@CrossOrigin
@RequestMapping(value="/discount")
public class PutDiscountController {
  
  
@Autowired
private PutDiscountService putDiscountService;

//Permet de créer un nouveau discount
@PostMapping
public void savePutDiscount(@RequestBody PutDiscount putDiscount) {
 putDiscountService.savePutDiscount(putDiscount);
}

//Pb de serialisation
@GetMapping("/all")
public List<PutDiscount> getAllDiscounts() {
    return putDiscountService.getAllDiscounts();
}

// Permet de rechercher un discount by Id
@GetMapping("{id}")
public PutDiscount getPutDiscountById(@PathVariable(name="id") Long id) {
  return putDiscountService.getPutDiscountById(id);
}


}
