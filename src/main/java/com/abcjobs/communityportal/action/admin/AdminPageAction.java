package com.abcjobs.communityportal.action.admin;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.abcjobs.communityportal.dao.AccountDAO;
import com.abcjobs.communityportal.dao.AdminDAO;
import com.abcjobs.communityportal.model.user.UserModel;
import com.opensymphony.xwork2.ActionSupport;

public class AdminPageAction extends ActionSupport implements SessionAware {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4960488514866168531L;
	
	private Map<String, Object> session;
	private List<UserModel> users;

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
		
		AdminDAO adm = new AdminDAO();
		setUsers(adm.getAllUsers());
		
		return SUCCESS;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public List<UserModel> getUsers() {
		return users;
	}

	public void setUsers(List<UserModel> users) {
		this.users = users;
	}

}
