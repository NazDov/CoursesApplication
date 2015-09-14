package org.nazar.loginOPT;

import java.awt.HeadlessException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.nazar.service.LoginService;

/**
 * Servlet implementation class RegisterServer
 */
@WebServlet("/RegisterServer")
public class RegisterServer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static boolean isSaved;
	private static boolean isValid;
	private JFrame frame = new JFrame("JOptionPane showMessageDialog example");
	private static String message;
	private LoginService service;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");
		String userEmail = request.getParameter("userEmail");
		
		if(!checkNotBlank(response, userId, userName, userPassword)){
			
			return;
		}
		
		isValid = LoginService.passwordValidityCheck(userPassword);
		
		System.out.println(userId+" "+userName+" "+userPassword+" "+userEmail);
		
		saveToDB(response, userId, userName, userPassword, userEmail);
		
		redirect(response);
		
	}

	private void redirect(HttpServletResponse response)
			throws HeadlessException, IOException {
		
		if(isSaved){
			
			message="registration complete";
			
			JOptionPane.showMessageDialog(frame, message);
			
			response.sendRedirect("login.jsp");	
			
		}else{
			
			response.sendRedirect("register.html");	
			
		}
	}

	private void saveToDB(HttpServletResponse response, String userId,
			String userName, String userPassword, String userEmail)
			throws IOException {
		service = new LoginService();
		
		try {
			
	
			if(isValid){
				
				isSaved=service.saveUserData(userId, userName, userPassword, userEmail);
				
			}
			
			
			
		} catch (SQLException e) {
			
			System.err.print("Error while saving into DB "+e.getMessage());
			
			message="ERROR! couldnt perform saveToDB()";
			
			JOptionPane.showMessageDialog(frame, message);
			
		}
	}

	private boolean checkNotBlank(HttpServletResponse response, String userId,
			String userName, String userPassword) throws IOException {
		if(userId.trim()=="" 
				|| userName.trim()=="" 
				|| userPassword.trim()=="" ){
			
			message= "fields cannot be blank";
			
			JOptionPane.showMessageDialog(frame, message);
			
			response.sendRedirect("register.html");
			
			return false;
		}
		
		return true;
	}

}
