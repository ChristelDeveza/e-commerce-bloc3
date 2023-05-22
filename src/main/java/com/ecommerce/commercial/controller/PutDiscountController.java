package com.ecommerce.commercial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.commercial.config.JwtConfig;
import com.ecommerce.commercial.model.PutDiscount;
import com.ecommerce.commercial.service.PutDiscountService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
@RequestMapping(value="/discount")
public class PutDiscountController {
  
  
@Autowired
private PutDiscountService putDiscountService;

//Permet de créer un nouveau discount
@PostMapping
public ResponseEntity<String> savePutDiscount(@RequestBody PutDiscount putDiscount, HttpServletRequest request) {
  String jwt = request.getHeader("Authorization");
    String newJwt = jwt.replace("Bearer ", "");
    System.out.print(newJwt);
    if (newJwt == null || newJwt.isEmpty()) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("JWT manquant");
    }

    if (JwtConfig.validateJwt(newJwt)) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("JWT invalide");
    }
 putDiscountService.savePutDiscount(putDiscount);
 return ResponseEntity.ok("Promotion créée avec succès");

}

//Pb de serialisation
@GetMapping("/all")
public List<PutDiscount> getAllDiscounts() {
    return putDiscountService.getAllDiscounts();
}

// Permet de rechercher un discount by Id
@GetMapping("{id}")
public ResponseEntity<Object> getPutDiscountById(@PathVariable(name="id") Long id, HttpServletRequest request) {
  String jwt = request.getHeader("Authorization");
    
    if (jwt == null || jwt.isEmpty()) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
    }
    String newJwt = jwt.replace("Bearer ", "");
    System.out.print(newJwt);
    if (JwtConfig.validateJwt(newJwt)) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
    }
   PutDiscount discountId = putDiscountService.getPutDiscountById(id);
    return ResponseEntity.ok(discountId);
}


}
