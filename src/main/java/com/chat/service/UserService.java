package com.chat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chat.entities.User;
import com.chat.repositories.UserRepository;

@Service
public class UserService implements UserServiceContract{

	@Autowired 
	private UserRepository userRepo;

	@Override
	public User findByPhone(Long phone) {
		User users = userRepo.findByPhone(phone);
		return users;
	}
	@Override
	public List<User> findAll() {
		List<User> users = userRepo.findAll();
		return users;
	}
	
	
	
}
