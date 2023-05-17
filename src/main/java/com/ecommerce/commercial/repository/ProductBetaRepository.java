package com.ecommerce.commercial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.commercial.model.ProductBeta;

@Repository
public interface ProductBetaRepository extends JpaRepository<ProductBeta, Long>{
  
}
