package com.ecommerce.commercial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.commercial.model.UpdateProduct;

@Repository
public interface UpdateProductRepository extends JpaRepository<UpdateProduct, Long> {
  
}
