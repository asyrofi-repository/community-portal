package com.abcjobs.communityportal.action.account;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class NewPasswordPageAction extends ActionSupport implements SessionAware {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6459148355700125127L;
	
	private Map<String, Object> session;
	
	@Override
	public String execute() throws Exception {
		if (session.isEmpty() || !session.containsKey("username")) {
			return LOGIN;
		}
		System.out.println("session : " + session.get("username").toString());
		return SUCCESS;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
