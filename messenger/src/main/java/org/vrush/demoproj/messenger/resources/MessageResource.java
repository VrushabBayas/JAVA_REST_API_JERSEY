package org.vrush.demoproj.messenger.resources;
import org.vrush.demoproj.messenger.service.MessageService;
import org.vrush.demoproj.messenger.model.Message;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Produces;
@Path("/messages")
public class MessageResource {
	
	MessageService messageservice = new MessageService();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages() {
		return messageservice.getAllMessages();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message addMessage(Message message) {
		return messageservice.addMessage(message);
	}
	
	
	@GET
	@Path("/{messageID}")
	@Produces(MediaType.APPLICATION_JSON)
	public 	Message getMessage(@PathParam("messageID") long id) {
		return messageservice.getMessages(id);
	}

}
