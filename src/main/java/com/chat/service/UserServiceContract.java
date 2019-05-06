package com.chat.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.chat.entities.User;
public interface UserServiceContract {

	User findByPhone(Long phone);
	List<User> findAll();
}
