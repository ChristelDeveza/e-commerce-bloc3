package com.ecommerce.commercial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.commercial.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository <Category, Long> {
  
}
