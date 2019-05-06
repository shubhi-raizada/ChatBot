package com.chat.service;

import java.util.List;


import org.springframework.data.repository.query.Param;

import com.chat.entities.Message;

public interface MessageServiceContract {
	List<Message> findMessageByUser(@Param("phone") Long phone);
	void saveMessage(@Param("toUser") Long toUser,
					   @Param("fromUser") Long fromUser,
					   @Param("msgText") String msgText);
}
