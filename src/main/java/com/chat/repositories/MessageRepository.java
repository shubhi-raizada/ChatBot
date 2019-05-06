package com.chat.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.chat.entities.Message;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long>{
	@Modifying
	@Query(value="Select * from message where to_user = :phone or from_user= :phone order by time_stamp desc",nativeQuery = true)
	@Transactional  
	List<Message> findMessageByUser(@Param("phone") Long phone);
	
	@Modifying
	@Query(value="insert into Message(to_User,from_User,msg_Text,time_stamp) VALUES (:toUser,:fromUser,:msgText,current_timestamp())",nativeQuery = true)
	@Transactional
	void saveMessage(@Param("toUser") Long toUser,
					   @Param("fromUser") Long fromUser,
					   @Param("msgText") String msgText);
}
