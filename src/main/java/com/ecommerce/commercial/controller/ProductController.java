package com.ecommerce.commercial.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.commercial.config.JwtConfig;
import com.ecommerce.commercial.model.Product;
import com.ecommerce.commercial.service.ProductService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
@RequestMapping(value="/products")
public class ProductController {

  @Autowired
  private ProductService productService;
  
@GetMapping
  public List<Product> getAllProducts() {
    return productService.getAllProducts();
  }

@GetMapping("{id}")
  public Product getProductById(@PathVariable(name="id") Long id) {
    return productService.getProductById(id);
  }

// @PutMapping("{id}")
//   public void updateProduct(@PathVariable(name="id") Long id, @RequestBody Product product) {
//     productService.updateProduct(id, product);
//   }

// @DeleteMapping("{id}")
//   public void deleteProduct(@PathVariable(name="id") Long id) {
//     productService.deleteProduct(id);
// }

@DeleteMapping("{id}")
public ResponseEntity<String> deleteProduct(@PathVariable(name="id") Long id, HttpServletRequest request) {
    String jwt = request.getHeader("Authorization");
    
    if (jwt == null || jwt.isEmpty()) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
    }
    String newJwt = jwt.replace("Bearer ", "");
    System.out.print(newJwt);
    if (JwtConfig.validateJwt(newJwt)) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
    }
    
    productService.deleteProduct(id);
    return ResponseEntity.ok("Produit supprimé avec succès");
}

}