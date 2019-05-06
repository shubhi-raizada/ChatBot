package com.chat.repositories;

import java.util.List;

//import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.chat.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface UserRepository extends CrudRepository<User,Long>{

	@Query("select u from User u where u.phone = ?1")
	User findByPhone(Long phone);
	
	@Query("select u from User u")
	List<User> findAll();
	
}