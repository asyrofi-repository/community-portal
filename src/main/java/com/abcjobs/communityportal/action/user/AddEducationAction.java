package com.abcjobs.communityportal.action.user;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.abcjobs.communityportal.dao.AccountDAO;
import com.abcjobs.communityportal.dao.UserDAO;
import com.abcjobs.communityportal.model.user.EducationModel;
import com.opensymphony.xwork2.ActionSupport;

public class AddEducationAction extends ActionSupport implements SessionAware {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7733718127413452080L;
	
	private Map<String, Object> session;
	private EducationModel education;

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
		
		education.setUsername(session.get("username").toString());
		ud.addEducation(education);
		
		return SUCCESS;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public EducationModel getEducation() {
		return education;
	}

	public void setEducation(EducationModel education) {
		this.education = education;
	}

}
