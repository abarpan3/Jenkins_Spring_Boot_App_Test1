package com.lti.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("status")
public class Status {
	
	public Status() {
		super();
	}

	private int status;
	
	private String email;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Status(int status, String email) {
		super();
		this.status = status;
		this.email = email;
	}
	
	
	
	
}
