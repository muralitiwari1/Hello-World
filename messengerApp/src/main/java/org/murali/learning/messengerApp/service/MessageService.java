package org.murali.learning.messengerApp.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.murali.learning.messengerApp.databaseStub.DatabaseClass;
import org.murali.learning.messengerApp.model.Message;

public class MessageService {
	Map<Long,Message> messages=DatabaseClass.getMessages();
	
	public MessageService(){
		messages.put(1L, new Message(1,"Murali",new Date(),"system"));
		messages.put(2L, new Message(2,"Vipin",new Date(),"system"));
	}
	public List<Message> getAllMessages(){
		return new ArrayList<>(messages.values());
		
	}
	public List<Message> getAllMessagesByYear(int year){
		List<Message> messageList= new ArrayList<>();
		Calendar cal= Calendar.getInstance();
		for (Message message : messageList) {
			cal.setTime(message.getCreated());
			if(cal.get(Calendar.YEAR)==year){
				messageList.add(message);
			}
		}
		return messageList;
		
	}
	public List<Message> getAllMessagesPaginated(int start,int size){
		List<Message> messageList= new ArrayList<>(messages.values());
		if(start+size>messageList.size()){
			return new ArrayList<Message>();
		}
		return messageList.subList(start, start+size);
		
	}

	
	public Message getMessage(Long id){
		return messages.get(id);
	
	}
	public Message addMessage(Message message){
		 message.setId(messages.size()+1);
		 messages.put(message.getId(), message);
		 return message;
	}
	public Message updateMessage(Message message){
		if (message.getId() <=0) {
			return null;
		}
		 messages.put(message.getId(), message);
		 return message;
				
	}
	public Message deleteMessage(Long id){
		return messages.remove(id);
		
	}
}
