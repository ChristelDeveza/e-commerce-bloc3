package com.ecommerce.commercial.service;

import com.ecommerce.commercial.model.User;

public interface UserService {
  User findByUsername(String username);
}
