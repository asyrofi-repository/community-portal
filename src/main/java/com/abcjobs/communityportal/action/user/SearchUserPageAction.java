package com.abcjobs.communityportal.action.user;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.abcjobs.communityportal.dao.AccountDAO;
import com.opensymphony.xwork2.ActionSupport;

public class SearchUserPageAction extends ActionSupport implements SessionAware {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8114326049650262062L;
	
	private Map<String, Object> session;

	@Override
	public String execute() throws Exception {
		if (session.isEmpty() || !session.containsKey("username")) {
			return LOGIN;
		}
		
		AccountDAO ad = new AccountDAO();
		if (ad.checkStatus(session.get("username").toString())) {
			session.clear();
			return LOGIN;
		}
		return SUCCESS;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
