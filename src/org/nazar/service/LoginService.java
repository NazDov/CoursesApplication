package org.nazar.service;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.nazar.*;
import org.nazar.service.dataVerify.*;
import org.nazar.user.User;
import org.nazar.dao.UserDAO;

public class LoginService {
	
	private UserDAO uDao = new UserDAO();
	private static boolean ERROR = false; 
	private List<User> userList;
	private static JFrame frame = new JFrame("JOptionPane showMessageDialog example");
	private static String errorMessage;
	
	
	public boolean checkIfHasCourses(User user) throws SQLException{
		
		return uDao.checkIfhasCourses(user);
		
	}
	
	public boolean saveUserData(String userId, String userName,
			String userPassword,
			String userEmail) throws SQLException{
		
		User user = new User();
		
		if(this.authenticate(userId, userPassword)){
			
			errorMessage="user with this id and password already exists";
			
			JOptionPane.showMessageDialog(frame, errorMessage );
			
			return false;
			
		}else{
			
			user.setUserName(userName);
			user.setUserPassword(userPassword);
			user.setUserId(userId);
			user.setUserEmail(userEmail);
			
			System.out.println(user);
			
			uDao.saveUserData(user);
			
			return true;
		}
		
		
	}
	
	public boolean updateUserData(String userId, String userData) 
			throws SQLException{
	
		
		boolean updated = uDao.updateUserData(userId,  userData);
	
			System.out.println(updated);
			
		if(updated){
			
			return true;
			
		}else{
			
			
			return false;
		}
		
		
		
	}
	
	
	public User getUserData(String userInfo){
		
		User user = null;
		
		userList = uDao.fetchedUserData();
		
		for(int index=0; index<userList.size(); index++){
			
			 user = userList.get(index);
			
			if(user!=null && (user.getUserId().equals(userInfo)
					|| user.getUserEmail().equals(userInfo))){
				
				return user;
				
			}else{
				
				continue;
			}
			
		}
		
		
		return user;
	}
	
	public boolean search(String userData, String userPassword){
		
		
		userList = uDao.fetchedUserData();
		
		for(User user : userList){
			
			if((user.getUserId().equals(userData) ||
					user.getUserEmail().equals(userData))
					&& ( user.getUserPassword().equals(userPassword))){
				
				
				return true;
				
			}else{
				
				continue;
			}
			
		}
		
		
		
		return ERROR;
	}

	public boolean authenticate(String userId, String userPassword){
		
		userList = uDao.fetchedUserData();
		
		boolean isfound=false;
		
		if(userList!=null){
			
			for(User user: userList){
				
				if(user.getUserId().equals(userId) ||
						user.getUserPassword().equals(userPassword)){
					
					isfound=true;
					
				}else{
					
					
					isfound=false;
				}
				
				
				if(isfound==false){
					
					continue;
					
				}else{
					
					return true;
				}
				
				
			}
			
			
			
		}else{
			
			throw new NullPointerException("no list object available");
		}
		
		return ERROR;
		
	}
	
	 public static boolean passwordValidityCheck(String input){
         
         if(DataVerify.isValidlength(input)){
                   
                   
                    if(DataVerify.foundUpperCase(input) && DataVerify.isDigit(input)){
                   
                   
                    System.out.println("password is OK");
                    
                    return true;
                    
                   
                    }else{
                   
                    	errorMessage = "check! should contain at least one Uppercase letter and digits";
                    	
                    System.out.println(errorMessage);
                    
                    JOptionPane.showMessageDialog(frame, errorMessage);
                    
                    return false;
                }
                   
                   
         		}else{
                   
         			errorMessage="password length should be at least 8 digits";
                   
                    System.out.println(errorMessage);
                    
                    JOptionPane.showMessageDialog(frame, errorMessage);
                    
                    return false;
                   
                   
         }
         
	 }

}
