package org.nazar.loginOPT;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.joda.time.DateTime;
import org.nazar.dao.CourseDAO;
import org.nazar.dao.UserDAO;
import org.nazar.dbconex.DBConnection;
import org.nazar.service.ApplicationService;
import org.nazar.service.LoginService;
import org.nazar.user.Course;
import org.nazar.user.User;
import org.nazar.user.UserCourse;

/**
 * Servlet implementation class LoginServer
 */
@WebServlet("/myLogin")
public class LoginServer extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static List<Course> courses; 
	private LoginService service;
	private CourseDAO cDao = new CourseDAO();
	private Course course;
	private UserCourse userCourse;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServer() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String userData;
		String userPassword;
	
		userData = request.getParameter("userData");
		userPassword=request.getParameter("userPassword");
		//userPassword = request.getParameter("userPassword");
		
		
		
		service = new LoginService();
		
		//boolean rezult = service.authenticate(userId, userPassword);
		
		boolean isFound = service.search(userData, userPassword);
		
		System.out.println(isFound);
		
		if(isFound){
			
			try {
				
				
				courses=CourseDAO.getCourses();
				User user = service.getUserData(userData);
				boolean hasCourses = service.checkIfHasCourses(user);
				
				course = cDao.getCourseByUser(user);
				userCourse=ApplicationService.returnApliedCourseDetailsForUser(course, user);
				String formattedDate =getFormattedDate();
				user.setHasCourses(hasCourses);
				user.setUserDate(formattedDate);
				request.setAttribute("user", user);
				request.setAttribute("courses", courses);
				request.setAttribute("userCourse", userCourse);
				RequestDispatcher dispatcher = request.getRequestDispatcher("success.jsp");
				dispatcher.forward(request, response);
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			//String userName = user.getUserName();
			
			return;
			
		}else{
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
			
			JFrame frame = new JFrame("JOptionPane showMessageDialog example");
			
			JOptionPane.showMessageDialog(frame, "user and passwod are incorrect");
			
			return;
			
		}
		
	
		
	}

	private String getFormattedDate() {
		Date date = new Date();
		
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, Locale.US);
		
		return dateFormat.format(date);
	}
		
}
