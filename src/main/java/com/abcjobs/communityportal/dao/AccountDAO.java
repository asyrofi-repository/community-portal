package com.abcjobs.communityportal.dao;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.abcjobs.communityportal.model.user.UserModel;

public class AccountDAO {
	
	public boolean checkUsername(String username) {
		
        boolean result = true;
		
		try (Connection connection = ConnectionDAO.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT `username` FROM `user` WHERE `username` = ? LIMIT 1");) {
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                result = false;
                break;
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
	
	public boolean checkEmail(String email) {
		
		boolean result = true;
		
		try (Connection connection = ConnectionDAO.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT `email` FROM `user` WHERE `email` = ? LIMIT 1");) {
            preparedStatement.setString(1, email);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                result = false;
                break;
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
	
	public boolean checkStatus(String username) {
		
		boolean result = false;
		
		try (Connection connection = ConnectionDAO.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT `username` FROM `user` WHERE `username` = ? AND `status` = 'disabled' LIMIT 1");) {
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                result = true;
                break;
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
	
	public String register(UserModel user) throws MalformedURLException, IOException {
		
		String result = "";
		
		if (checkUsername(user.getUsername())) {
			if (checkEmail(user.getEmail())) {
				
				String query = "INSERT INTO `user` (`username`, `password`, `role`, `first_name`, `last_name`, `birth_place`, `birth_date`, `gender`, `city`, `country`, `email`, `photo`, `status`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
				
				try (Connection connection = ConnectionDAO.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
		            
					preparedStatement.setString(1, user.getUsername());
		            preparedStatement.setString(2, user.getPassword());
		            preparedStatement.setString(3, "Software Programmer");
		            preparedStatement.setString(4, user.getFirst_name());
		            preparedStatement.setString(5, user.getLast_name());
		            preparedStatement.setString(6, user.getBirth_place());
		            preparedStatement.setString(7, user.getBirth_date());
		            preparedStatement.setString(8, user.getGender());
		            preparedStatement.setString(9, user.getCity());
		            preparedStatement.setString(10, user.getCountry());
		            preparedStatement.setString(11, user.getEmail());
		            //preparedStatement.setString(12, "./assets/img/default_profile.jpg");
		            InputStream in = new URL("http://localhost:8080/ID0420FF05I/assets/img/default_profile.jpg").openStream();
		            preparedStatement.setBlob(12, in);
		            preparedStatement.setString(13, "active");
		            
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
				
			} else {
				result = "err_email";
			}
		} else {
			result = "err_username";
		}
		
		return result;
	}
	
	public String setTokenPassword(String username, String token) {
		String result = "";
		
		String query1 = "DELETE FROM `password_token` WHERE `username` = ?;";
		String query2 = "INSERT INTO `password_token` (`username`, `token`) VALUES (?, ?);";
		
		try (Connection connection = ConnectionDAO.getConnection()) {
			
			PreparedStatement preparedStatement = connection.prepareStatement(query1);
			PreparedStatement preparedStatement2 = connection.prepareStatement(query2);
            
			preparedStatement.setString(1, username);
			
			preparedStatement2.setString(1, username);
            preparedStatement2.setString(2, token);
            
            preparedStatement.executeUpdate();
            preparedStatement2.executeUpdate();
            
            result = "success";
            
            preparedStatement.close();
            preparedStatement2.close();
            if (connection != null) {
				connection.close();
			}
            
        } catch (SQLException e) {
        	result = "err_insert";
            e.printStackTrace();
        }
		
		return result;
	}
	
	public String resetTokenPassword(String token) {
		String result = "";
		
		String query1 = "SELECT * FROM `password_token` WHERE `token` = ? LIMIT 1;";
		String query2 = "DELETE FROM `password_token` WHERE `token` = ?;";
		
		try (Connection connection = ConnectionDAO.getConnection()) {
			
			PreparedStatement preparedStatement1 = connection.prepareStatement(query1);
			PreparedStatement preparedStatement2 = connection.prepareStatement(query2);
            
			preparedStatement1.setString(1, token);
			preparedStatement2.setString(1, token);
            
			ResultSet rs = preparedStatement1.executeQuery();

			result = "err_token";
			while (rs.next()) {
				result = rs.getString("username");
			}
            preparedStatement2.executeUpdate();
            
            preparedStatement1.close();
            if (connection != null) {
				connection.close();
			}
            
        } catch (SQLException e) {
        	result = "err_insert";
            e.printStackTrace();
        }
		
		return result;
	}
	
	public String updatePassword(String username, String password) {
		
		String result = "";
		
		String query = "UPDATE `user` SET `password` = ? WHERE `username` = ?;";
		
		try (Connection connection = ConnectionDAO.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            
			preparedStatement.setString(1, password);
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
	
	public boolean login(String username, String password) {
		
		boolean result = false;
		
		try (Connection connection = ConnectionDAO.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT `username` FROM `user` WHERE `username` = ? AND `password` = ? LIMIT 1");) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                result = true;
                break;
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
}
