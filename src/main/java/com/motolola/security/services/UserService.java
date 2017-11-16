package com.motolola.security.services;

import com.motolola.security.models.User;

public interface UserService {
	public User findUserByEmail(String email);
	public void saveUser(User user);
}