package org.nazar.loginOPT;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.nazar.dao.CourseDAO;
import org.nazar.dao.UserDAO;
import org.nazar.service.ApplicationService;
import org.nazar.service.DataStorage;
import org.nazar.user.Course;
import org.nazar.user.User;

/**
 * Servlet implementation class ApplicationConnect
 */
@WebServlet("/applicationConnect")
public class ApplicationConnect extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ApplicationService service= new ApplicationService();
	private static UserDAO uDao=ApplicationService.getUserDAO();
	private static CourseDAO cDao=ApplicationService.getCourseDAO();
	private static boolean isUpdated;
	private User user;
	private Course course;
	private JFrame frame = new JFrame("JOptionPane showMessageDialog example");
	private String message;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplicationConnect() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.sendRedirect("login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String courseName = request.getParameter("courseName");
		String userId = request.getParameter("userId");
		
		courseName = format(courseName);
		
		System.out.println("Course Name: "+courseName);
		System.out.println("User ID: "+userId);
	
		
		try {
		
			isUpdated =service.tableUserCourseUpdate(userId, courseName);
			
			if(isUpdated){
				
				user=uDao.getDataByName(userId);
				course =cDao.getDataByName(courseName);

				DataStorage.getData().put(user, course);
				
				System.out.println(DataStorage.getData());
				
				message="Data is updated! Thank You!";
				
				JOptionPane.showMessageDialog(frame, message);
				
				response.sendRedirect("login.jsp");
				
			}else{
				
				message="Error! Data wasnt updated";
				
				JOptionPane.showMessageDialog(frame, message);
				
				
				return;
				
			}
			
			
		} catch (SQLException e) {
			
			System.out.println("(user_courses) table data insert error");
		}
		
		
		
		
		
	}

	private String format(String courseName) {
		String [] lines = courseName.split(" 2");
		String line =lines[0];
		
		return line;
	}

}
