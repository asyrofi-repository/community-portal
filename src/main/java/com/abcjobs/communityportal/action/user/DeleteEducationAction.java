package com.abcjobs.communityportal.action.user;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.abcjobs.communityportal.dao.AccountDAO;
import com.abcjobs.communityportal.dao.UserDAO;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteEducationAction extends ActionSupport implements SessionAware {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4075256736075078773L;
	
	private Map<String, Object> session;
	private int education_id;

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
		ud.deleteEducation(education_id);
		
		return SUCCESS;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public int getEducation_id() {
		return education_id;
	}

	public void setEducation_id(int education_id) {
		this.education_id = education_id;
	}

}
