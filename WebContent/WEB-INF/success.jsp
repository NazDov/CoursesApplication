<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<%@ page import ="java.util.*"%>
<%@ page import ="org.joda.time.*"%>
<%@page import = "org.nazar.service.*" %>
<%@page import = "org.nazar.user.User" %>
<!DOCTYPE html>
<html >
  <head>
    <meta charset="UTF-8">
    <title>Verification App</title>
    
    
    
    
        <link rel="stylesheet" href="css/style.css">

    
    
    
  </head>

  <body>

    <div class="wrapper">
	<div class="container">
	
<!--  <jsp:useBean id="user" class="org.nazar.user.User" scope="request" >
	
</jsp:useBean>
 -->

<h3>Hello, ${user.userName} ! Your login was successful on <%=new Date().toString() %></h3>
	<c:if test="${user.hasCourses}">
		You have already applied for our courses. Please check details that were sent to your email.
		<table style="width:100%">
		  <tr>
		    <th>User ID</th>
		    <th>User Name</th>		
		    <th>User Email</th>
		    <th>Course Number</th>
		    <th>Course Name</th>		
		    <th>course Date</th>
		  </tr>
		  <tr>
		    <td>${user.userId}</td>
		    <td>${user.userName}</td>		
		    <td>${user.userEmail}</td>
		    <td>${userCourse.courseNumber}</td>
		    <td>${userCourse.courseName}</td>		
		    <td>${userCourse.courseDate}</td>
		  </tr>
		</table>
		
	</c:if>	
	<c:if test="${empty user.userEmail}">
	<p> You didnt specify your email</p>
	<p>Please provide your email below</p>
	<p>You will shortly receive info on your email</p>
	<form class="form" action="UpdateServer" method="post">
			<input type="text" name="userId" value="${user.userId}" readonly/>
			<input type="email" name="userEmail" placeholder="email">
			<button type="submit" id="login-button">Submit</button><br>
		</form>
	</c:if>
	<c:if test="${not empty user.userEmail}">
	<c:if test="${!user.hasCourses}">
			<h2><b>Registration Form</b></h2>
	<p>You can now apply for our courses</p>
	<form method="post" action="applicationConnect" id="selform">
         <input name ="userId" type="text" value="${user.userId}" readonly/>
         <input name ="userName" type="text" value="${user.userName}" readonly/>
         <input name ="userEmail" type="email" size="40" value="${user.userEmail}" readonly />
         
           <select name="courseName" id="course_name">
            	<c:forEach var="course" items="${courses}" >
                <option>
                	<c:out value="${course.courseName}"/>
                	<c:if test="${course.courseName == 'java for begginers'}">
                		${course.courseDate}
               		</c:if>
               		<c:if test="${course.courseName == 'java advanced'}">
                		${course.courseDate}
               		</c:if>
                </option>
                </c:forEach>
            </select> 
            <textarea cols="50" rows="5" id="message" placeholder="additional details..."></textarea>
  <div id="buttons">
  		 <button type="submit" class="action">Submit</button>
        <button type="reset" class="action">Reset</button>
  </div>
       
   
</form>
	
	</c:if>
	
	 </c:if>
	 
	 <c:if test="${isUpdated.booleanValue()}">
	 	<p> your email is updated!</p>
	 </c:if>
	 	
	</div>
	
	<ul class="bg-bubbles">
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
	</ul>
</div>
    <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

        <script src="js/index.js"></script>

  </body>
</html>
