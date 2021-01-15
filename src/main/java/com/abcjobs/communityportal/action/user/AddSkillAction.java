package com.abcjobs.communityportal.action.user;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.abcjobs.communityportal.dao.AccountDAO;
import com.abcjobs.communityportal.dao.UserDAO;
import com.abcjobs.communityportal.model.user.SkillModel;
import com.opensymphony.xwork2.ActionSupport;

public class AddSkillAction extends ActionSupport implements SessionAware {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5899181588435888812L;
	
	private Map<String, Object> session;
	private SkillModel skill;
	private String msgSkill;

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
		String username = session.get("username").toString();
		UserDAO ud = new UserDAO();
		setMsgSkill(ud.addSkill(username, skill.getSkill_name()));
		
		return SUCCESS;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public SkillModel getSkill() {
		return skill;
	}

	public void setSkill(SkillModel skill) {
		this.skill = skill;
	}

	public String getMsgSkill() {
		return msgSkill;
	}

	public void setMsgSkill(String msgSkill) {
		this.msgSkill = msgSkill;
	}

}
