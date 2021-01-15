package com.abcjobs.communityportal.action.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.abcjobs.communityportal.dao.AccountDAO;
import com.abcjobs.communityportal.dao.UserDAO;
import com.abcjobs.communityportal.model.user.EducationModel;
import com.abcjobs.communityportal.model.user.SkillModel;
import com.abcjobs.communityportal.model.user.UserModel;
import com.abcjobs.communityportal.model.user.WorkHistoryModel;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateProfilePageAction extends ActionSupport implements SessionAware {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3738948837237194920L;
	
	private Map<String, Object> session;
	private UserModel user;
	private List<SkillModel> skills = new ArrayList<>();
	private List<EducationModel> educations = new ArrayList<>();
	private List<WorkHistoryModel> workHistories = new ArrayList<>();
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
		
		setUser(ud.getUserProfile(username));
		setSkills(ud.getSkills(username));
		setEducations(ud.getEducations(username));
		setWorkHistories(ud.getWorkHistories(username));
		
		return SUCCESS;
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

	public List<SkillModel> getSkills() {
		return skills;
	}

	public void setSkills(List<SkillModel> skills) {
		this.skills = skills;
	}

	public List<EducationModel> getEducations() {
		return educations;
	}

	public void setEducations(List<EducationModel> educations) {
		this.educations = educations;
	}

	public List<WorkHistoryModel> getWorkHistories() {
		return workHistories;
	}

	public void setWorkHistories(List<WorkHistoryModel> workHistories) {
		this.workHistories = workHistories;
	}

	public String getMsgSkill() {
		return msgSkill;
	}

	public void setMsgSkill(String msgSkill) {
		this.msgSkill = msgSkill;
	}

}
