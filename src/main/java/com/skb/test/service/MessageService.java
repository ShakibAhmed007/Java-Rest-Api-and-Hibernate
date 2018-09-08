package com.skb.test.service;

import java.util.List;

import com.skb.test.beans.ResponseMessage;
import com.skb.test.dao.MessageDao;
import com.skb.test.entity.Message;

public class MessageService {

	public MessageDao md = null;
	
	public MessageService() {
		if(md == null) {
			md= new MessageDao();
		}
	}

	public ResponseMessage getMessages() {
		return md.getMessages();
	}

	public ResponseMessage getMessagesById(String id) {
		return md.getMessagesById(id);
	}

	public ResponseMessage addMessage(Message message) {
		return md.addMessage(message);
	}

	public ResponseMessage updateMessage(Message message) {
		return md.updateMessage(message);
	}

	public ResponseMessage deleteMessage(Message message) {
		return md.deleteMessage(message);
	}

	public ResponseMessage getMessagesByDate(String date) {
		return md.getMessagesByDate(date);
	}

}
