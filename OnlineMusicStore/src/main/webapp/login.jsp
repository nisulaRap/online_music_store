<!-- IT Number : IT22050908 -->
<!-- Name		 : Premaratne R.A.N.C. --> 

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="css/login.css"> <!-- external css --> 
<title>Login Page</title>
</head>
<body>

	<div class="image"> <!-- adding image -->
		<div class="login_form">  <!--login form begins-->
			<form method="post" action="loginConServlet">
            	<div class="login_hedding">Login</div> <!--contains login hedding-->

	                <div class="input_details"> <!--contains input name and password-->
    	                <input type="text" class="fullname" placeholder="Full name" name="uname"  required><!--login enter full name-->
                        <input type="password" class="pword" placeholder="password" name="pword" required> <!--login enter password-->
                    </div> 

                    <div class> <!--login button-->
	                    <button type="submit" class="login">Login</button>
                    </div>                              

                    <div class="formlinks"><!--contians remeber me and do you have an account-->        
                    	<div class="register"><!--register-->
                        	<lable class="dhaccount">Dont have an account?</lable><a href> register</a>
                        </div>
                    </div>
                </div>
			</form>
		</div> <!--form ends-->
	</div>

</body>
</html>