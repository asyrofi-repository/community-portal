package com.abcjobs.communityportal.action.account;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.abcjobs.communityportal.dao.AccountDAO;
import com.opensymphony.xwork2.ActionSupport;

public class CheckPasswordTokenAction extends ActionSupport implements SessionAware {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4662912190543355663L;
	
	private String token;
	private String username;
	private String errMsg;
	private Map<String, Object> session;

	@Override
	public String execute() throws Exception {
		AccountDAO ad = new AccountDAO();
		String check = ad.resetTokenPassword(token);
		System.out.println("chk : " + check);
		if (check == "err_insert" || check == "err_token") {
			setErrMsg(check);
			return ERROR;
		}
		setUsername(check);
		session.put("username", username);
		return SUCCESS;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

}
