package test;

import org.nazar.service.LoginService;

public class AuthenticationTest {
	
	
	public static void main(String [] args){
		
		
		LoginService testService = new LoginService();
		
		boolean rezult = testService.search("user", "user");
		
		if(rezult== true
				|| rezult== false  ){
			
			System.out.println("OK");
			
		}else{
			
			
			System.out.println("Error inside authenticate()");
		}
		
		
		
		
		
	}

}
