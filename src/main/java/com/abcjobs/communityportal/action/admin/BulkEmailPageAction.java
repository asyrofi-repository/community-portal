package com.abcjobs.communityportal.action.admin;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.abcjobs.communityportal.dao.AccountDAO;
import com.opensymphony.xwork2.ActionSupport;

public class BulkEmailPageAction extends ActionSupport implements SessionAware {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7181918489806729832L;
	private Map<String, Object> session;

	@Override
	public String execute() throws Exception {
		
		if (session.isEmpty()) {
			return ERROR;
		}
		
		String role = session.get("role").toString();
		
		AccountDAO ad = new AccountDAO();
		if (ad.checkStatus(session.get("username").toString()) || !role.equals("Admin")) {
			return ERROR;
		}
		return SUCCESS;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
