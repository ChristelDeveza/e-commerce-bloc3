package com.ecommerce.commercial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.commercial.model.PutDiscount;

@Repository
public interface PutDiscountRepository extends JpaRepository<PutDiscount, Long> {
  
}
