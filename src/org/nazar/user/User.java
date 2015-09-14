package org.nazar.user;

public class User {
	
	private int id;
	private String userId=null;
	private String userPassword=null;
	private String userName=null;
	private String userEmail=null;
	private boolean hasCourses;
	private String userDate;
	
	
	public String getUserDate(){
		
		return userDate;
	}
	
	public void setUserDate(String userDate){
		this.userDate=userDate;
	}
	
	public boolean isHasCourses() {
		return hasCourses;
	}

	public void setHasCourses(boolean hasCourses) {
		this.hasCourses = hasCourses;
	}

	public User(){
		
		// default. needed for jsp:useBean class definition
	}
	
	public User(int id, String userId, String userPassword, String userName, String userEmail){
		
		this.id=id;
		this.userId=userId;
		this.userPassword=userPassword;
		this.userName=userName;
		this.userEmail=userEmail;
		
	}
	
		
	
	
		public int getId() {
		return id;
	}

	

		@Override
		public String toString() {
			return "User [id=" + id + ", userId=" + userId + ", userPassword="
					+ userPassword + ", userName=" + userName + ", userEmail="
					+ userEmail + "]";
		}

		public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

		public void setUserId(String userId){
			
			this.userId=userId;
		}
		
		public String getUserId(){
			
			return userId;
		}
		
		
	    public void setUserPassword(String userPassword){
			
			this.userPassword=userPassword;
		}
		

		public String getUserPassword(){
			
			return userPassword;
		}


		public String getUserName() {
			// TODO Auto-generated method stub
			return userName;
		}
		
		public void setUserName(String userName){
			
			this.userName=userName;
		}
}
