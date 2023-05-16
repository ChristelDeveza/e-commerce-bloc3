package com.ecommerce.commercial.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.commercial.model.Discount;
import com.ecommerce.commercial.model.Product;
import com.ecommerce.commercial.repository.ProductRepository;
import com.ecommerce.commercial.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

  @Autowired
  private ProductRepository productRepository;

  private static List<Product> maListe = new ArrayList<>();

  @Override
  public List<Product> getAllProducts() {
   return productRepository.findAll();
  }

  @Override
  public Product getProductById(Long id) {
    Optional<Product> productId = productRepository.findById(id);
    return productId.orElse(null);
  }

  


  // @Override
  // public void updateProduct(Long id, Product product) {
  //   Optional<Product> existingProduct = productRepository.findById(id);
  //   if (existingProduct.isPresent()) {
  //     Product updatedProduct = existingProduct.get();
  //     if (product.getName() != null) {
  //       updatedProduct.setName(product.getName());
  //     }
  //     if (product.getPrice() != null) {
  //       updatedProduct.setPrice(product.getPrice());
  //     }



  //     // Vérifier si le produit a un discount associé et si la date actuelle est comprise entre la date de début et de fin
  //     Discount discount = updatedProduct.getDiscount();
  //     if (discount != null && isWithinDiscountPeriod(discount)) {
  //       // Calculer le montant du prix modifié
  //       Long discountPercentage = discount.getPercentage()/ 100;
  //       Long discountedPrice = updatedProduct.getPrice() * (1 - discountPercentage);
  //       updatedProduct.setDiscountedPrice(discountedPrice);
  //     } else {
  //       // Pas de discount ou en dehors de la période de discount, utiliser le prix initial
  //       updatedProduct.setDiscountedPrice(updatedProduct.getPrice());
  //     }

  //     productRepository.save(updatedProduct);
  //   }
  // }

  // private boolean isWithinDiscountPeriod(Discount discount) {
  //   LocalDate currentDate = LocalDate.now();
  //   return currentDate.isEqual(discount.getStartDate()) || currentDate.isAfter(discount.getStartDate())
  //       && (discount.getEndDate() == null || currentDate.isBefore(discount.getEndDate()));
  // }

  @Override
  public void deleteProduct(Long id) {
    productRepository.deleteById(id);
  }
  
}