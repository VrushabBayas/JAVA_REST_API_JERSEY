package org.vrush.demoproj.messenger.resources;
import org.vrush.demoproj.messenger.service.MessageService;
import org.vrush.demoproj.messenger.model.Message;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Produces;
@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {
	
	MessageService messageservice = new MessageService();
	//get getting all the messages
	@GET
	public List<Message> getMessages() {
		return messageservice.getAllMessages();
	}
	
	//return message corresponding to id
	@GET
	@Path("/{messageID}")
	public 	Message getMessage(@PathParam("messageID") long id) {
		return messageservice.getMessages(id);
	}
	
	//post new message
	@POST
	public Message addMessage(Message message) {
		return messageservice.addMessage(message);
	}
	
	//for updating message based on the id
	@PUT
	@Path("/{messageID}")
	public Message updateMessage(@PathParam("messageID") long id,Message message) {
		message.setId(id);
		return messageservice.updateMessage(message);
	}
	
	//Delete specific message by id
	@DELETE
	@Path("/{messageID}")
	public  Message deleteMessage(@PathParam("messageID")long id) {
	 return messageservice.removeMessage(id);
	}
	
	

}
