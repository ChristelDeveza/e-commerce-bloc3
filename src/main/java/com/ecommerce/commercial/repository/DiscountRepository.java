package com.ecommerce.commercial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.commercial.model.Discount;

@Repository
public interface DiscountRepository extends JpaRepository <Discount, Long>{
  
}
