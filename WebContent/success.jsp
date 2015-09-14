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
		<meta name="viewport" content="width=device-width, initial-scale=1">
  		<link rel="stylesheet" href="css/bootstrap.min.css">
  		<link rel="stylesheet" href="css/bootstrap.css">
  		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  		<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    
    
    
  </head>

  <body>

    <div class="container">
	<div class="main">
	<div class="jumbotron">
	
<!--  <jsp:useBean id="user" class="org.nazar.user.User" scope="request" >
	
</jsp:useBean>
 -->

<h4>Hello, ${user.userName} ! Your login was successful on ${user.userDate} </h4>
	<c:if test="${user.hasCourses}">
		You have already applied for our courses. Please check details that were sent to your email.
		<div class="row">
			 <div class="col-xs-12 col-md-8">
		<table class="table table-bordered">
		  <tr class="danger" >
		    <th class="danger"><b>User ID</b></th>
		    <th class="danger"><b>User Name</b></th>		
		    <th class="danger"><b>User Email</b></th>
		  </tr>
		  <tr class="active">
		    <td class="warning">${user.userId}</td>
		    <td class="warning">${user.userName}</td>		
		    <td class="warning">${user.userEmail}</td>
		  </tr>
		  <tr class="info">
		    <th class="danger"><b>Course Number</b></th>
		    <th class="danger"><b>Course Name</b></th>		
		    <th class="danger"><b>Course Date</b></th>
		  </tr>
		   <tr class="warning">
		    <td class="warning">${userCourse.courseNumber}</td>
		    <td class="warning">${userCourse.courseName}</td>		
		    <td class="warning">${userCourse.courseDate}</td>
		  </tr>
		</table>
			 
			 </div>
			
		</div>
	</c:if>	
	<c:if test="${empty user.userEmail}">
	<p> You didnt specify your email</p>
	<p>Please provide your email below</p>
	<p>You will shortly receive info on your email</p>
	<form class="form" action="UpdateServer" method="post">
		  <div class="form-group">
			<input type="text" class="form-control" id="exampleInputEmail1" name="userId" value="${user.userId}" readonly/>
		 </div>
		 <div class="form-group">
			<input type="email" class="form-control" id="exampleInputEmail1" name="userEmail" placeholder="email">
		 </div>	
		 <p>
			<button type="submit" class="btn btn-primary" id="login-button">Submit</button>
		 </p>
		</form>
	</c:if>
	<c:if test="${not empty user.userEmail}">
	<c:if test="${!user.hasCourses}">
			<h2>Registration Form</h2>
	<p>You can now apply for our courses</p>
	<form class="form" method="post" action="applicationConnect" id="selform">
		  <div class="form-group">
          	   	<input name ="userId" class="form-control" id="exampleInputEmail1" type="text" value="${user.userId}" readonly/>
			</div>	
			<div class="form-group">
        		 <input name ="userName" class="form-control" id="exampleInputEmail1" type="text" value="${user.userName}" readonly/>
			</div>
			<div class="form-group">	 
        		  <input name ="userEmail" class="form-control" id="exampleInputEmail1" type="email" size="40" value="${user.userEmail}" readonly />
			</div>	  
         
           <select name="courseName" >
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
			<p>
  		 	   <button type="submit" class="btn btn-primary">Submit</button>
			</p>   
			<p>
        	<button type="reset" class="btn btn-primary">Reset</button>
			</p>
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

</div>
    <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

        <script src="js/index.js"></script>

  </body>
</html>
