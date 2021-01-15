package com.abcjobs.communityportal.action.admin;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.abcjobs.communityportal.action.account.EmailSender;
import com.abcjobs.communityportal.dao.AccountDAO;
import com.opensymphony.xwork2.ActionSupport;

public class BulkEmailAction extends ActionSupport implements SessionAware {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5006110739253407496L;
	private Map<String, Object> session;
	private String email;
	private String subject;
	private String content;
	private String msg;

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
		
		if (EmailSender.send(email, subject, content).equalsIgnoreCase("success")) {
			setMsg("success");
		}
		
		return SUCCESS;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
