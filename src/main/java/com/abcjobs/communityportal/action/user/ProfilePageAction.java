package com.abcjobs.communityportal.action.user;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

public class ProfilePageAction extends ActionSupport implements SessionAware {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4155321009188371645L;
	
	private Map<String, Object> session;
	private UserModel user;
	private List<SkillModel> skills = new ArrayList<>();
	private List<EducationModel> educations = new ArrayList<>();
	private List<WorkHistoryModel> workHistories = new ArrayList<>();
	private String usr;

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
		if (usr != null) {
			if (!ad.checkUsername(usr)) {
				username = usr;
			}
		}
		
		System.out.println(username);
		
		UserDAO ud = new UserDAO();
		
		setUser(ud.getUserProfile(username));
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat format2 = new SimpleDateFormat("dd MMMM yyyy");
		Date date = format1.parse(user.getBirth_date());
		user.setBirth_date(format2.format(date));
		
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

	public String getUsr() {
		return usr;
	}

	public void setUsr(String usr) {
		this.usr = usr;
	}

}
