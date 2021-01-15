package com.abcjobs.communityportal.action.account;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.abcjobs.communityportal.dao.AccountDAO;
import com.abcjobs.communityportal.dao.UserDAO;
import com.abcjobs.communityportal.model.user.UserModel;
import com.opensymphony.xwork2.ActionSupport;

public class SendPasswordLinkAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6895844930003255797L;
	
	private String errMsg;
	private String username;

	@Override
	public String execute() throws Exception {
		
		AccountDAO ad = new AccountDAO();
		if (ad.checkUsername(username)) {
			setErrMsg("err_username");
			return ERROR;
		}
		UserDAO ud = new UserDAO();
		UserModel user = ud.getUserProfile(username);
		String url = "http://localhost:8080/ID0420FF05I/check_password_token.action";
		String token = getMd5(username + "_" + java.time.LocalDateTime.now());
		System.out.println(ad.setTokenPassword(username, token));
		String content = "Please use the link below to change your password. </br></br><a href='" + url + "?token=" + token + "'>Reset Password</a>";
		EmailSender.send(user.getEmail(), "Password Recovery Link", content);
		setErrMsg("success");
		
		return SUCCESS;
	}
	
	public String getMd5(String input) 
    { 
        try { 
  
            // Static getInstance method is called with hashing MD5 
            MessageDigest md = MessageDigest.getInstance("MD5"); 
  
            // digest() method is called to calculate message digest 
            //  of an input digest() return array of byte 
            byte[] messageDigest = md.digest(input.getBytes()); 
  
            // Convert byte array into signum representation 
            BigInteger no = new BigInteger(1, messageDigest); 
  
            // Convert message digest into hex value 
            String hashtext = no.toString(16); 
            while (hashtext.length() < 32) { 
                hashtext = "0" + hashtext; 
            } 
            return hashtext; 
        }  
  
        // For specifying wrong message digest algorithms 
        catch (NoSuchAlgorithmException e) { 
            throw new RuntimeException(e); 
        } 
    } 

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
