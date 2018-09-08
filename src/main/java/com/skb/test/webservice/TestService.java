package com.skb.test.webservice;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.skb.test.beans.ResponseMessage;
import com.skb.test.entity.Message;
import com.skb.test.service.MessageService;

@Path("testService")
public class TestService {

	public MessageService ms;

	{
		ms = new MessageService();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseMessage getMessage() {
		return ms.getMessages();
	}

	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseMessage getMessageById(@PathParam("messageId") String messageId) {
		return ms.getMessagesById(messageId);

	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseMessage updateMessage(Message message) {
		return ms.updateMessage(message);

	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseMessage deleteMessage(Message message) {
		return ms.deleteMessage(message);

	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseMessage addMessage(Message message) {
		return ms.addMessage(message);
	}


	/*
	 * Query Parameter Example
	 * Request Is
	 * http://localhost:8085/webservice/api/testService/filterByDate?date=2018-08-07
	 */
	
	@GET
	@Path("/filterByDate")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseMessage getMessagesByDate(@QueryParam("date") String date) {
		return ms.getMessagesByDate(date);
	}
}
