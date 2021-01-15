package com.abcjobs.communityportal.dao;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import com.abcjobs.communityportal.model.user.EducationModel;
import com.abcjobs.communityportal.model.user.SkillModel;
import com.abcjobs.communityportal.model.user.UserModel;
import com.abcjobs.communityportal.model.user.WorkHistoryModel;

public class UserDAO {
	
	public UserModel getUserProfile(String username) {
		
		UserModel user = null;
		Blob image = null;
		byte[] imgData = null;
		String base64Image = null;
		
		try (Connection connection = ConnectionDAO.getConnection();
	            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM `user` WHERE `username` = ? LIMIT 1");) {
	            preparedStatement.setString(1, username);
	            ResultSet rs = preparedStatement.executeQuery();

	            while (rs.next()) {
	            	user = new UserModel();
	            	user.setUsername(rs.getString("username"));
	            	user.setPassword(rs.getString("password"));
	            	user.setRole(rs.getString("role"));
	            	user.setFirst_name(rs.getString("first_name"));
	            	user.setLast_name(rs.getString("last_name"));
	            	user.setBirth_place(rs.getString("birth_place"));
	            	user.setBirth_date(rs.getString("birth_date"));
	            	user.setGender(rs.getString("gender"));
	            	user.setCity(rs.getString("city"));
	            	user.setCountry(rs.getString("country"));
	            	user.setEmail(rs.getString("email"));
	            	image = rs.getBlob("photo");
	            	imgData = image.getBytes(1, (int) image.length());
	            	base64Image = Base64.getEncoder().encodeToString(imgData);
	            	System.out.println(base64Image);
	            	user.setPhoto(base64Image);
	            	user.setStatus(rs.getString("status"));
	            }
	            preparedStatement.close();
	            if (connection != null) {
					connection.close();
				}
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
		return user;
	}
	
	public List<UserModel> searchUser(String key, String search) {
		
		List<UserModel> result = new ArrayList<>();
		UserModel user = null;
		Blob image = null;
		byte[] imgData = null;
		String base64Image = null;
		String query = "SELECT * FROM (SELECT `username`, CONCAT_WS(' ',`first_name`,`last_name`) AS name, `city`, `country`, `photo` FROM `user`) AS user WHERE #key LIKE ?";
		query = query.replace("#key", key);
		
		try (Connection connection = ConnectionDAO.getConnection();
	            PreparedStatement preparedStatement = connection.prepareStatement(query);) {
	            preparedStatement.setString(1, "%" + search + "%");
	            ResultSet rs = preparedStatement.executeQuery();

	            while (rs.next()) {
	            	user = new UserModel();
	            	user.setUsername(rs.getString("username"));
	            	user.setFirst_name(rs.getString("name"));
	            	user.setCity(rs.getString("city"));
	            	user.setCountry(rs.getString("country"));
	            	image = rs.getBlob("photo");
	            	imgData = image.getBytes(1, (int) image.length());
	            	base64Image = Base64.getEncoder().encodeToString(imgData);
	            	System.out.println(base64Image);
	            	user.setPhoto(base64Image);
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
	
	public String updateProfile(UserModel user) {
		
		String result = "";
		
		String query = "UPDATE `user` SET `first_name` = ?, `last_name` = ?, `birth_place` = ?, `birth_date` = ?, `gender` = ?, `city` = ?, `country` = ?, `email` = ? WHERE `username` = ?;";
		
		try (Connection connection = ConnectionDAO.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            
			preparedStatement.setString(1, user.getFirst_name());
            preparedStatement.setString(2, user.getLast_name());
            preparedStatement.setString(3, user.getBirth_place());
            preparedStatement.setString(4, user.getBirth_date());
            preparedStatement.setString(5, user.getGender());
            preparedStatement.setString(6, user.getCity());
            preparedStatement.setString(7, user.getCountry());
            preparedStatement.setString(8, user.getEmail());
            preparedStatement.setString(9, user.getUsername());
            
            System.out.println(preparedStatement.executeUpdate());;
            
            result = "success";
            
            preparedStatement.close();
            if (connection != null) {
				connection.close();
			}
        } catch (SQLException e) {
        	result = "err_update";
            e.printStackTrace();
        }
		
		return result;
	}
	
	public List<SkillModel> getSkills(String username) {
		
		List<SkillModel> result = new ArrayList<>();
		SkillModel temp = null;
		
		try (Connection connection = ConnectionDAO.getConnection();
	            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM `skill` WHERE `username` = ? ORDER BY `skill_name`");) {
	            preparedStatement.setString(1, username);
	            ResultSet rs = preparedStatement.executeQuery();

	            while (rs.next()) {
	            	temp = new SkillModel();
	            	temp.setSkill_id(rs.getInt("skill_id"));
	            	temp.setUsername(rs.getString("username"));
	            	temp.setSkill_name(rs.getString("skill_name"));
	            	result.add(temp);
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

	public boolean checkSkill(String username, String skill) {
		
		boolean result = true;
		
		try (Connection connection = ConnectionDAO.getConnection();
	            PreparedStatement preparedStatement = connection.prepareStatement("SELECT `username` FROM `skill` WHERE `username` = ? AND `skill_name` = ? LIMIT 1");) {
	            preparedStatement.setString(1, username);
	            preparedStatement.setString(2, skill);
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
	
	public String addSkill(String username, String skill) {
		
		String result = "";
		String query = "INSERT INTO `skill` (`username`, `skill_name`) VALUES (?, ?);";
		
		if (checkSkill(username, skill)) {
			try (Connection connection = ConnectionDAO.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            
	            preparedStatement.setString(1, username);
	            preparedStatement.setString(2, skill);
	            
	            preparedStatement.executeUpdate();
	            
	            result = "success";
	            
	        } catch (SQLException e) {
	        	result = "err_insert";
	            e.printStackTrace();
	        }
		} else {
			result = "err_skill";
		}
		
		return result;
	}
	
	public String deleteSkill(SkillModel skill) {
		
		String result = "";
		String query = "DELETE FROM `skill` WHERE `skill_id` = ?";
		
		try (Connection connection = ConnectionDAO.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            
            preparedStatement.setInt(1, skill.getSkill_id());
            
            preparedStatement.executeUpdate();
            
            result = "success";
            
        } catch (SQLException e) {
        	result = "err_insert";
            e.printStackTrace();
        }
		
		return result;
	}
	
	public List<WorkHistoryModel> getWorkHistories(String username) {
		
		List<WorkHistoryModel> result = new ArrayList<>();
		WorkHistoryModel temp = null;
		
		try (Connection connection = ConnectionDAO.getConnection();
	            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM `work_history` WHERE `username` = ? ORDER BY `start_year` DESC");) {
	            preparedStatement.setString(1, username);
	            ResultSet rs = preparedStatement.executeQuery();

	            while (rs.next()) {
	            	temp = new WorkHistoryModel();
	            	temp.setWork_id(rs.getInt("work_id"));
	            	temp.setUsername(rs.getString("username"));
	            	temp.setCompany(rs.getString("company"));
	            	temp.setPosition(rs.getString("position"));
	            	temp.setStart_year(rs.getInt("start_year"));
	            	temp.setEnd_year(rs.getInt("end_year"));
	            	result.add(temp);
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
	
	public String addWorkHistory(WorkHistoryModel work) {

		String result = "";
		String query = "INSERT INTO `work_history` (`username`, `company`, `position`, `start_year`, `end_year`) VALUES (?, ?, ?, ?, ?);";
		
		try (Connection connection = ConnectionDAO.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
          
			preparedStatement.setString(1, work.getUsername());
            preparedStatement.setString(2, work.getCompany());
            preparedStatement.setString(3, work.getPosition());
            preparedStatement.setInt(4, work.getStart_year());
            preparedStatement.setInt(5, work.getEnd_year());
            
            preparedStatement.executeUpdate();
            
            result = "success";
            
        } catch (SQLException e) {
        	result = "err_insert";
            e.printStackTrace();
        }
		
		return result;
	}
	
	public String deleteWorkHistory(int id) {
		
		String result = "";
		String query = "DELETE FROM `work_history` WHERE `work_id` = ?";
		
			try (Connection connection = ConnectionDAO.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            
	            preparedStatement.setInt(1, id);
	            
	            preparedStatement.executeUpdate();
	            
	            result = "success";
	            
	        } catch (SQLException e) {
	        	result = "err_insert";
	            e.printStackTrace();
	        }
		
		
		return result;
	}
	
	public List<EducationModel> getEducations(String username) {
		
		List<EducationModel> result = new ArrayList<>();
		EducationModel temp = null;
		
		try (Connection connection = ConnectionDAO.getConnection();
	            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM `education` WHERE `username` = ? ORDER BY `start_year` DESC");) {
	            preparedStatement.setString(1, username);
	            ResultSet rs = preparedStatement.executeQuery();

	            while (rs.next()) {
	            	temp = new EducationModel();
	            	temp.setEducation_id(rs.getInt("education_id"));
	            	temp.setUsername(rs.getString("username"));
	            	temp.setSchool(rs.getString("school"));
	            	temp.setMajor(rs.getString("major"));
	            	temp.setStart_year(rs.getInt("start_year"));
	            	temp.setEnd_year(rs.getInt("end_year"));
	            	result.add(temp);
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

	public String addEducation(EducationModel education) {

		String result = "";
		String query = "INSERT INTO `education` (`username`, `school`, `major`, `start_year`, `end_year`) VALUES (?, ?, ?, ?, ?);";
		
		try (Connection connection = ConnectionDAO.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
          
			preparedStatement.setString(1, education.getUsername());
            preparedStatement.setString(2, education.getSchool());
            preparedStatement.setString(3, education.getMajor());
            preparedStatement.setInt(4, education.getStart_year());
            preparedStatement.setInt(5, education.getEnd_year());
            
            preparedStatement.executeUpdate();
            
            result = "success";
            
        } catch (SQLException e) {
        	result = "err_insert";
            e.printStackTrace();
        }
		
		return result;
	}
	
	public String deleteEducation(int id) {
		
		String result = "";
		String query = "DELETE FROM `education` WHERE `education_id` = ?";
		
			try (Connection connection = ConnectionDAO.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            
	            preparedStatement.setInt(1, id);
	            
	            preparedStatement.executeUpdate();
	            
	            result = "success";
	            
	        } catch (SQLException e) {
	        	result = "err_insert";
	            e.printStackTrace();
	        }
		
		return result;
	}
	
	public String updatePhoto(String username, InputStream photo) {
		
		String result = "";
		String query = "UPDATE `user` SET `photo` = ? WHERE `user`.`username` = ?;";
		
			try (Connection connection = ConnectionDAO.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            
	            preparedStatement.setBlob(1, photo);
	            preparedStatement.setString(2, username);
	            
	            preparedStatement.executeUpdate();
	            
	            result = "success";
	            
	        } catch (SQLException e) {
	        	result = "err_insert";
	            e.printStackTrace();
	        }
		
		return result;
	}
}
