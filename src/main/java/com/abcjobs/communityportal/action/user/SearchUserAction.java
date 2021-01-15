package com.abcjobs.communityportal.action.user;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.abcjobs.communityportal.dao.AccountDAO;
import com.abcjobs.communityportal.dao.UserDAO;
import com.abcjobs.communityportal.model.user.UserModel;
import com.opensymphony.xwork2.ActionSupport;

public class SearchUserAction extends ActionSupport implements SessionAware {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8688867249844288253L;
	
	private Map<String, Object> session;
	private List<UserModel> users;
	private String key;
	private String search;

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
		
		UserDAO ud = new UserDAO();
		setUsers(ud.searchUser(key, search));
		
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

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

}
