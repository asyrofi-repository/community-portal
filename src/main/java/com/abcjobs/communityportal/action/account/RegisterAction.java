package com.abcjobs.communityportal.action.account;

import com.abcjobs.communityportal.dao.AccountDAO;
import com.abcjobs.communityportal.model.user.UserModel;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7093042717558058236L;
	
	private UserModel user;
	private String errMsg;

	@Override
	public String execute() throws Exception {
		
		AccountDAO ad = new AccountDAO();
		setErrMsg(ad.register(user));
		System.out.println(errMsg);
		
		if (errMsg != "success") {
			return ERROR;
		}
		
		String message = "Hi, <strong>" + user.getFirst_name() + "</strong>. Your account was successfuly created !";

		EmailSender.send(user.getEmail(), "Account Registration Successful", message);
		
		return SUCCESS;
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
