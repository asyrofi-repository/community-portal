package com.abcjobs.communityportal.action.user;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.abcjobs.communityportal.dao.AccountDAO;
import com.abcjobs.communityportal.dao.UserDAO;
import com.abcjobs.communityportal.model.user.WorkHistoryModel;
import com.opensymphony.xwork2.ActionSupport;

public class AddWorkHistoryAction extends ActionSupport implements SessionAware {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5064494985577347694L;
	
	private Map<String, Object> session;
	private WorkHistoryModel work;

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
		work.setUsername(session.get("username").toString());
		ud.addWorkHistory(work);
		
		return SUCCESS;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public WorkHistoryModel getWork() {
		return work;
	}

	public void setWork(WorkHistoryModel work) {
		this.work = work;
	}

}
