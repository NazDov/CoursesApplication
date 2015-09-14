package org.nazar.service;

import java.util.HashMap;
import java.util.Map;

import org.nazar.user.Course;
import org.nazar.user.User;

public class DataStorage {
	
	private static Map<User, Course> dataVal = getData();
	
	
	private DataStorage(){
		
		///
	}

	public static Map<User, Course> getData() {
		if(dataVal==null){
			
			dataVal= new HashMap<User, Course>();
			
		}
		
		
		return dataVal;
	}
	
	public static void addData(User user, Course course){
		
		dataVal.put(user, course);
		
		
	}
	
	

}
