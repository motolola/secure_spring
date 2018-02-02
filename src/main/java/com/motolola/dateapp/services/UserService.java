package com.motolola.dateapp.services;

import com.motolola.dateapp.models.User;

public interface UserService {
	public User findUserByEmail(String email);
	public void saveUser(User user);
}