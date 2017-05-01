package org.murali.learning.messengerApp.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {
	private long id;
	private String message;
	private Date created;
	private String auther;
	
	public Message()
	{
		
	}
	
	public Message(long id, String message, Date created, String auther) {
		super();
		this.id = id;
		this.message = message;
		this.created = created;
		this.auther = auther;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getAuther() {
		return auther;
	}
	public void setAuther(String auther) {
		this.auther = auther;
	}
	
}
