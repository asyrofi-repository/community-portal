package com.abcjobs.communityportal.action.account;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.abcjobs.communityportal.dao.AccountDAO;
import com.abcjobs.communityportal.dao.UserDAO;
import com.abcjobs.communityportal.model.user.UserModel;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4262303458233226349L;
	
	private Map<String, Object> session;
	private UserModel user;
	private String errMsg;

	@Override
	public String execute() throws Exception {
		AccountDAO ad = new AccountDAO();
		if (ad.login(user.getUsername(), user.getPassword())) {
			UserDAO ud = new UserDAO();
			user = ud.getUserProfile(user.getUsername());
			session.clear();
			if (user.getStatus().equalsIgnoreCase("active")) {
				session.put("username", user.getUsername());
				session.put("role", user.getRole());
				return SUCCESS;
			}
			setErrMsg("err_disabled");
			return LOGIN;
		}
		setErrMsg("err_login");
		return LOGIN;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

}
