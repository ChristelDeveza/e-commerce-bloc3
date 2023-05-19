package com.ecommerce.commercial.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.commercial.model.DiscountBeta;

@Repository
public interface DiscountBetaRepository extends JpaRepository<DiscountBeta, Long> {

  
}
