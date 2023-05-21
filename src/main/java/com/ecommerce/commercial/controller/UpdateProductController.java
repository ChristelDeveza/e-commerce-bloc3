package com.ecommerce.commercial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.commercial.config.JwtConfig;
import com.ecommerce.commercial.model.UpdateProduct;
import com.ecommerce.commercial.service.UpdateProductService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
@RequestMapping(value="/update")
public class UpdateProductController {
  
@Autowired
private UpdateProductService updateProductService;

  
@PutMapping("{id}")
public ResponseEntity<String> updateProduct(@PathVariable(name="id") Long id, @RequestBody UpdateProduct updateProduct, HttpServletRequest request) {
  String jwt = request.getHeader("Authorization");
  String newJwt = jwt.replace("Bearer ", "");
  System.out.print(newJwt);
  if (newJwt == null || newJwt.isEmpty()) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("JWT manquant");
  }

  if (JwtConfig.validateJwt(newJwt)) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("JWT invalide");
  }
  updateProductService.updateProduct(id, updateProduct);
  return ResponseEntity.ok("Produit mis à jour avec succès");
}
}