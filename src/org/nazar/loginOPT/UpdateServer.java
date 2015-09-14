package org.nazar.loginOPT;

import java.io.IOException;
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
 * Servlet implementation class UpdateServer
 */
@WebServlet("/UpdateServer")
public class UpdateServer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServer() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	
    	
    	
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String userId = request.getParameter("userId");
		String userData = request.getParameter("userEmail");
		
		System.out.println(userId+" "+userData);
		LoginService service = new LoginService();
		
		
		try {
			
			boolean isUpdated=service.updateUserData(userId, userData);
			
			if(isUpdated){
				
				request.setAttribute("isUpdated", isUpdated);
				RequestDispatcher dispatcher =request.getRequestDispatcher("login.jsp");
				dispatcher.forward(request, response);
				JFrame frame = new JFrame("JOptionPane showMessageDialog example");
				
				JOptionPane.showMessageDialog(frame, "data was updated. thank you");
				
				return;
				
			}else{
				
				JFrame frame = new JFrame("JOptionPane showMessageDialog example");
				
				JOptionPane.showMessageDialog(frame, "data already exists");
				
				return;
				
			}
			
		} catch (SQLException e) {
			
			System.err.println("failed to update user data");;
		}
		
		
		
		
		
	}

}
