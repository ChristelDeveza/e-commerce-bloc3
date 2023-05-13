package com.ecommerce.commercial.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.commercial.model.Category;
import com.ecommerce.commercial.repository.CategoryRepository;
import com.ecommerce.commercial.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

  
  @Autowired
  private CategoryRepository categoryRepository;
  
  @Override
  public List<Category> getAllCategories() {
   return categoryRepository.findAll();
  }
}
