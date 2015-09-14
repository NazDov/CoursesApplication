
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Verification App</title>

        <link rel="stylesheet" href="css/style.css">
		<meta name="viewport" content="width=device-width, initial-scale=1">
  		<link rel="stylesheet" href="css/bootstrap.min.css">
  		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  		<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    
  </head>

  <body>
  <div class="outer">


  <div class="panel panel-primary panel-transparent">
  	   <div class="panel-heading">
    <h3 class="panel-title">Panel primary</h3>
  </div>
  		<div class="panel-body">
  
  	   <div class="container">
  	   <div class="jumbotron">
	   		<h1>Welcome</h1>
		
		<form class="form" action="myLogin" method="post">
			  <div class="form-group">
			  	   <input class="form-control" id="exampleInputEmail1" type="text" name="userData" placeholder="id or email">
			</div>
			<div class="form-group">
			 	 <input type="password" class="form-control" id="exampleInputPassword1" name="userPassword" placeholder="password">
			</div>
			<p>
			   <button type="submit" class="btn btn-primary btn-sm" id="login-button">Login</button><br>
			   <a type="button" class="btn btn-primary btn-sm" id="login-button" href="register.html">Register?</a>
			</p>
			
		</form>
	   
  	   </div>
  </div>
  		
		
</div>
   
  </div>
</div>
  
   </div> 

	
	
    <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

        <script src="js/index.js"></script>

    
  </body>
</html>
