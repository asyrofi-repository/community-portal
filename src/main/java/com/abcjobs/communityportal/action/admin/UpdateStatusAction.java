package com.abcjobs.communityportal.action.admin;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.abcjobs.communityportal.dao.AccountDAO;
import com.abcjobs.communityportal.dao.AdminDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateStatusAction extends ActionSupport implements SessionAware {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1531113957109633623L;
	private Map<String, Object> session;
	private String username;
	private String status;

	@Override
	public String execute() throws Exception {
		String role = session.get("role").toString();
		if (session.isEmpty() || !role.equals("Admin")) {
			return ERROR;
		}
		
		AccountDAO ad = new AccountDAO();
		if (ad.checkStatus(session.get("username").toString())) {
			return ERROR;
		}
		AdminDAO adm = new AdminDAO();
		adm.updateStatus(username, status);
		return SUCCESS;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
