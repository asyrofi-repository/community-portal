package com.abcjobs.communityportal.model.user;

public class EducationModel {
	private int education_id, start_year, end_year;
	private String username, school, major;
	public int getEducation_id() {
		return education_id;
	}
	public void setEducation_id(int education_id) {
		this.education_id = education_id;
	}
	public int getStart_year() {
		return start_year;
	}
	public void setStart_year(int start_year) {
		this.start_year = start_year;
	}
	public int getEnd_year() {
		return end_year;
	}
	public void setEnd_year(int end_year) {
		this.end_year = end_year;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
}
