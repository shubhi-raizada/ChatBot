package com.chat.controller;

import java.util.Collections;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chat.entities.Message;
import com.chat.entities.User;
import com.chat.service.MessageServiceContract;
import com.chat.service.UserServiceContract;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController 
@RequestMapping("/users")
@Api(value="chats", description="chat service for users", tags=("chats"))
public class ChatController {

	@Autowired
	 UserServiceContract userContract;
	
	@Autowired
	MessageServiceContract msgContract;
	
    @GetMapping
    @ApiOperation(value="Get All users in the system",notes="This endpoint finds a user by its phone number and if phone number is not given , lists all users",tags=("chats"))
    public List<User> findAll(@RequestParam(name="phone", required=false) Long phone) {
    	 
    	if(phone != null) {
    		return Collections.singletonList(this.userContract.findByPhone(phone));
    	}
    	
        return (List<User>)userContract.findAll();
}

    @GetMapping("/{phone}/messages")
    @ApiOperation(value="Get All messages",notes="This endpoint lists all messages of a given user",tags=("chats"))
    public List<Message> findMessageByUser(@PathVariable Long phone) {
    	if(phone != null) {
    		return Collections.synchronizedList(this.msgContract.findMessageByUser(phone));
    	}
        return null;
}
    @PostMapping("/{phone}/sendMessages")
    @ApiOperation(value="Send message",notes="This endpoint sends message text from one user to another user recording its timestamp",tags=("chats"))
    public String sendMessage(@PathVariable Long phone,@RequestBody Message msg) {
    	if(msg != null) {
    		msgContract.saveMessage(msg.getToUser(), msg.getFromUser(), msg.getMsgText());
       	 return "message sent";
    	}
    	 return "uanble to send message, please check message body again";
    }
}