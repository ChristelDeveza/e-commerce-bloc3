package com.ecommerce.commercial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.commercial.model.PostProduct;

@Repository
public interface PostProductRepository extends JpaRepository<PostProduct, Long> {
  
}

