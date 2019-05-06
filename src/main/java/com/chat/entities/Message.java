package com.chat.entities;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

@Entity
@Table(name = "Message")
@SqlResultSetMapping(name="messageResult")
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private long toUser;
	
	private long fromUser;

	private String msgText;
	
	private Timestamp time_stamp;
	
	public Timestamp getTime_stamp() {
		return time_stamp;
	}
	public void setTime_stamp(Timestamp time_stamp) {
		this.time_stamp = time_stamp;
	}
	public long getToUser() {
		return toUser;
	}
	public void setToUser(long toUser) {
		this.toUser = toUser;
	}
	public long getFromUser() {
		return fromUser;
	}
	public void setFromUser(long fromUser) {
		this.fromUser = fromUser;
	}
	public String getMsgText() {
		return msgText;
	}
	public void setMsgText(String msgText) {
		this.msgText = msgText;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
}