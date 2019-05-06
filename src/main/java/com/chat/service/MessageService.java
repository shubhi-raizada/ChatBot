package com.chat.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chat.entities.Message;
import com.chat.repositories.MessageRepository;

@Service
public class MessageService implements MessageServiceContract{
	
	@Autowired
	private MessageRepository msgRepo;
	
	@Autowired
	protected EntityManager em;
	
	@Override
	public List<Message> findMessageByUser(Long phone) {
		List<Message> msgs = msgRepo.findMessageByUser(phone);
		return msgs;
	}

	@Override
	public void saveMessage(Long toUser, Long fromUser, String msgText) {
		 msgRepo.saveMessage(toUser, fromUser, msgText);
	}

}
