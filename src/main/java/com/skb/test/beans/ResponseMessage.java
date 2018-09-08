package com.skb.test.beans;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.skb.test.entity.Message;

@XmlRootElement
public class ResponseMessage {

	private String responseType;
	private String responseCode;
	private Date responseTime;
	private List<Message> message;
	
	public ResponseMessage() {
		
	}

	public ResponseMessage(String responseType, String responseCode, Date responseTime, List<Message> message) {
		super();
		this.responseType = responseType;
		this.responseCode = responseCode;
		this.responseTime = responseTime;
		this.message = message;
	}



	public String getResponseType() {
		return responseType;
	}

	public void setResponseType(String responseType) {
		this.responseType = responseType;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public Date getResponseTime() {
		return responseTime;
	}

	public void setResponseTime(Date responseTime) {
		this.responseTime = responseTime;
	}

	public List<Message> getMessage() {
		return message;
	}

	public void setMessage(List<Message> message) {
		this.message = message;
	}

}
