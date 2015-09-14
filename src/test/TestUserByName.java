package test;

import java.sql.SQLException;

import org.nazar.dao.UserDAO;
import org.nazar.user.User;

public class TestUserByName {
	
	private static UserDAO udao = new UserDAO();
	

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		String expUserId="user89";
		
		User user = TestUserByName.udao.getDataByName(expUserId);
		
		String actualUserId = user.getUserId();
		
		
		if(expUserId.equals(actualUserId)){
			
			System.out.println("OK");
			
		}else{
			
			throw new AssertionError("incorrect data returned");
			
		}
		
		

	}

}
