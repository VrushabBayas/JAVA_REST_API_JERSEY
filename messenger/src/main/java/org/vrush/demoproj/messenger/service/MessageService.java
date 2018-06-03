package org.vrush.demoproj.messenger.service;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import org.vrush.demoproj.messenger.database.DatabaseClass;
import org.vrush.demoproj.messenger.model.Message;

public class MessageService {
	
	private static Map<Long,Message> messages =  DatabaseClass.getMessages();
	
	public MessageService() {
		messages.put(1l,new Message(1,"Hello world","Vrushab"));
		messages.put(2l,new Message(2,"Hello world Javax API","Vrushab"));
	}
	
	public List<Message> getAllMessages(){
		return new ArrayList<Message>(messages.values());
	}
	
	public Message getMessages(long id) {
		
		return messages.get(id);
	}
	
	public Message addMessage(Message message) {
		message.setId(messages.size()+1);
		messages.put(message.getId(),message);
		return message;
	}
	
	public Message updateMessage(Message message) {
		
		if(message.getId() <= 0) {
			return null;
		}
		messages.put(message.getId(),message);
		return message;
	}
	
	public Message removeMessage(long id) {
		
		return messages.remove(id);
	}

}
