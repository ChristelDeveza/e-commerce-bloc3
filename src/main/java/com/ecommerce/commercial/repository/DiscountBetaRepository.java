package com.ecommerce.commercial.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.commercial.model.DiscountBeta;
import com.ecommerce.commercial.model.ProductBeta;

@Repository
public interface DiscountBetaRepository extends JpaRepository<DiscountBeta, Long> {

  
}
