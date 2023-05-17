package com.ecommerce.commercial.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.commercial.model.DiscountBeta;
import com.ecommerce.commercial.model.ProductBeta;
import com.ecommerce.commercial.repository.DiscountBetaRepository;
import com.ecommerce.commercial.repository.ProductBetaRepository;
import com.ecommerce.commercial.service.ProductBetaService;

  @Service
public class ProductBetaServiceImpl implements ProductBetaService {

  @Autowired
  private ProductBetaRepository productBetaRepository;

  @Autowired
  private DiscountBetaRepository discountBetaRepository;

  @Override
  public ProductBeta getProductById(Long productId) {
      return productBetaRepository.findById(productId).orElse(null);
  }

  @Override
  public List<ProductBeta> getAllProducts() {
      return productBetaRepository.findAll();
  }

  @Override
  public ProductBeta saveProduct(ProductBeta productBeta) {
      return productBetaRepository.save(productBeta);
  }

  @Override
  public void deleteProduct(Long productId) {
      productBetaRepository.deleteById(productId);
  }

  @Override
  public DiscountBeta getDiscountById(Long discountId) {
      return discountBetaRepository.findById(discountId).orElse(null);
  }

  @Override
  public List<DiscountBeta> getAllDiscounts() {
      return discountBetaRepository.findAll();
  }

  // Lie le discount à un product mais met pas à jour de le prix
//   @Override
//   public void applyDiscountToProduct(Long productId, Long discountId) {
//       ProductBeta product = productBetaRepository.findById(productId).orElse(null);
//       DiscountBeta discount = discountBetaRepository.findById(discountId).orElse(null);

//       if (product != null && discount != null) {
//           product.setDiscountBeta(discount);
//           productBetaRepository.save(product);
//       }
// }

// Permet lors du post discount_id vers product de recalculer le prix avec application du pourcentage
@Override
public void applyDiscountToProduct(Long productId, Long discountId) {
    ProductBeta product = productBetaRepository.findById(productId).orElse(null);
    DiscountBeta discount = discountBetaRepository.findById(discountId).orElse(null);

    if (product != null && discount != null) {
        product.setDiscountBeta(discount);

        // Calcul du discountedPrice en utilisant le pourcentage de remise de la remise appliquée
        Long price = product.getPrice();
        Integer discountPercentage = discount.getPercentage();
        Long discountAmount = (price * discountPercentage) / 100;
        Long discountedPrice = price - discountAmount;

        // MAJ du discountedPrice du produit
        product.setDiscountedPrice(discountedPrice);

        productBetaRepository.save(product);
    }
}

}

