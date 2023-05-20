package com.ecommerce.commercial.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.commercial.model.User;
import com.ecommerce.commercial.repository.UserRepository;
import com.ecommerce.commercial.service.UserService;

@Service
public class UserServiceImpl implements UserService{

  @Autowired
  private UserRepository userRepository;

  @Override
  public User findByUsername(String username) {
  return  userRepository.findByUsername(username);

  }
  
}
