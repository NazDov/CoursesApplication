package org.nazar.dbconex;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.*;

public class DBConnection {
	
	private static Connection connection = null;
	
	private DBConnection(){
		//
	}
	
	public static Connection getConnection() throws SQLException{
		
		return prepareConnection();
	}
	
	private static Connection prepareConnection() throws SQLException{
		
	
		//String path ="com.mysql.jdbc.Driver";

		try {
			
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			
			
		} catch (SQLException e) {
			
			System.out.println("no driver found");
		}
		
		if(connection==null){
			
			connection = (Connection)DriverManager
					.getConnection(DBUrls.URL, DBUrls.USER, DBUrls.PASSWORD);
			
		}
		
		return connection;
		
	}
	
	public static void closeConnection(Connection connection){
		
		if(connection!=null){
			
			try {
				connection.close();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
	}
	
	

}
