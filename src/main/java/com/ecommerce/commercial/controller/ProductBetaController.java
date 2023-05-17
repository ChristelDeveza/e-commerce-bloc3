package com.ecommerce.commercial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.commercial.model.DiscountBeta;
import com.ecommerce.commercial.model.ProductBeta;
import com.ecommerce.commercial.service.ProductBetaService;

@RestController
@RequestMapping("/productsBeta")
public class ProductBetaController {

    @Autowired
    private ProductBetaService productBetaService;

    @GetMapping("/{productId}")
    public ResponseEntity<ProductBeta> getProductById(@PathVariable Long productId) {
        ProductBeta productBeta = productBetaService.getProductById(productId);
        if (productBeta != null) {
            return ResponseEntity.ok(productBeta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<ProductBeta>> getAllProducts() {
        List<ProductBeta> products = productBetaService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @PostMapping
    public ResponseEntity<ProductBeta> createProduct(@RequestBody ProductBeta productBeta) {
        ProductBeta savedProduct = productBetaService.saveProduct(productBeta);
        return ResponseEntity.ok(savedProduct);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId) {
        productBetaService.deleteProduct(productId);
        return ResponseEntity.noContent().build();
    }

    //Pb de serialisation
    @GetMapping("/discounts/{discountId}")
    public ResponseEntity<DiscountBeta> getDiscountById(@PathVariable Long discountId) {
        DiscountBeta discountBeta = productBetaService.getDiscountById(discountId);
        if (discountBeta != null) {
            return ResponseEntity.ok(discountBeta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Pb de sérialisation
    @GetMapping("/discounts")
    public ResponseEntity<List<DiscountBeta>> getAllDiscounts() {
        List<DiscountBeta> discounts = productBetaService.getAllDiscounts();
        return ResponseEntity.ok(discounts);
    }

    //Permet de lier un discount à un produit
    @PostMapping("/{productId}/discounts/{discountId}")
    public ResponseEntity<Void> applyDiscountToProduct(@PathVariable Long productId, @PathVariable Long discountId) {
        productBetaService.applyDiscountToProduct(productId, discountId);
        return ResponseEntity.ok().build();
    }
}
