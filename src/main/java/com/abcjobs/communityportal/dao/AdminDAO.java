package com.abcjobs.communityportal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.abcjobs.communityportal.model.user.UserModel;

public class AdminDAO {
	
	public List<UserModel> getAllUsers() {
		
		List<UserModel> result = new ArrayList<>();
		UserModel user = null;
		String query = "SELECT * FROM (SELECT `username`, CONCAT_WS(' ',`first_name`,`last_name`) AS name, `email`, `status` FROM `user`) AS user";
		
		try (Connection connection = ConnectionDAO.getConnection();
	            PreparedStatement preparedStatement = connection.prepareStatement(query);) {
	            ResultSet rs = preparedStatement.executeQuery();

	            while (rs.next()) {
	            	user = new UserModel();
	            	user.setUsername(rs.getString("username"));
	            	user.setFirst_name(rs.getString("name"));
	            	user.setEmail(rs.getString("email"));
	            	user.setStatus(rs.getString("status"));
	            	result.add(user);
	            }
	            preparedStatement.close();
	            if (connection != null) {
					connection.close();
				}
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
		return result;
	}
	
	public String updateStatus(String username, String status) {
		
		String result = "";
		
		String query = "UPDATE `user` SET `status` = ? WHERE `username` = ?;";
		
		try (Connection connection = ConnectionDAO.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            
			preparedStatement.setString(1, status);
            preparedStatement.setString(2, username);
            
            preparedStatement.executeUpdate();
            
            result = "success";
            
            preparedStatement.close();
            if (connection != null) {
				connection.close();
			}
            
        } catch (SQLException e) {
        	result = "err_insert";
            e.printStackTrace();
        }
		
		return result;
	}

}
