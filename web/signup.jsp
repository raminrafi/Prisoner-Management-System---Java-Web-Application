<%-- 
    Document   : signup
    Created on : Dec 27, 2020, 3:01:24 PM
    Author     : abc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="zxx">
<head>

<title>Police</title>
<link href="content/css/bootstrap.css" rel="stylesheet">
<link href="content/css/bootstrap.min.css" rel="stylesheet">
    <link href="content/css/font-awesome.min.css" rel="stylesheet">
    <link href="content/css/animate.min.css" rel="stylesheet">
    <link href="content/css/prettyPhoto.css" rel="stylesheet">
    
    <link href="content/css/responsive.css" rel="stylesheet">
    <script src="content/js/jquery.js"></script>
    <link rel="stylesheet" type="text/css" href="content/css/jquery.dataTables.css">
    <link rel="stylesheet" type="text/css" href="content/css/dataTables.bootstrap.css">
    <link rel="stylesheet" type="text/css" href="content/css/dataTables.responsive.css">

    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
    <link href='https://fonts.googleapis.com/css?family=Oswald:400,300' rel='stylesheet' type='text/css' >
<style type="text/css">
  body
  {
    font-family: Arial, Helvetica, sans-serif;
  margin: 0;
    background-color: lightgrey;
  }

.header {
  padding: 90px;
  text-align:center;
  background: black;
  color: lightgrey;
  font-variant: small-caps;
}

/* Increase the font size of the heading */
.header h1 {
  font-size: 36px; 
}
* {
  box-sizing: border-box;
}


.b1 {
  margin-left: 1250px;
  margin-top: 5px;
  border-radius: 4px;
  background-color:  #4d4dff;
  border: none;
  color: #FFFFFF;
  text-align: center;
  font-size: 15px;
  font-family: sans-serif;
  width: 100px;
  padding: 5px;
  transition: all 0.5s;
  cursor: pointer;
  
}

.b1 span {
  cursor: pointer;
  display: inline-block;
  position: relative;
  transition: 0.5s;
}

.b1 span:after {
  content: '\00bb';
  position: absolute;
  opacity: 0;
  top: 0;
  right: -20px;
  transition: 0.5s;
}

.b1:hover span {
  padding-right: 25px;

}

.b1:hover span:after {
  opacity: 1;
  right: 0;
}
.animate
{
	position:relative;animation:animatetop 0.4s
}
	@keyframes animatetop{from{top:-150px;opacity:0} to{top:0;opacity:1}}

.container {
  padding: 16px;
  background-color: white;
  margin-bottom: 20px;
    width: 50%;
}

/* Full-width input fields */
input[type=text], input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

/* Overwrite default styles of hr */
hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}

/* Set a style for the submit button */
.registerbtn {
  background-color: red;
  color: white;
  padding: 16px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
  font-size: 15px;
  font-family: sans-serif;
}

.registerbtn:hover {
  opacity: 1;
}
.signin {
  background-color: #f1f1f1;
  text-align: center;
}
label
{
  font-family: sans-serif;
  font-size: 12px;
}
p
{
  font-size: 12px;
  font-family: sans-serif;
}

</style>
</head>

<body>
	
		<div class="c1">
			
			<div class="header">
  <div class="animate" > <img style="width:150px; height: 150px; margin-top: 20px; margin-left: 20px;arg" src="content/images/logo.png" alt="Logo" style="max-width: 300px;"> 
      </div>
  <h1>Prisoner Management System</h1>  
</div>
      <form action="signupServlet" method="post">
  <div class="container">
    <h1>Register</h1>
    <p>Please fill in this form to create an account.</p>
    <hr>

    <label for="name"><b>Name</b></label>
    <input type="text" placeholder="Enter Name" name="name" id="name" required>

    <label for="age"><b>Age</b></label>
    <input style="  font-family: sans-serif;
  font-size: 12px; margin-left: 100px;width: 100px;" type="number" name="age" id="age" min="20" max="100" required>

    <br><br>
    <label for="gender"><b style="margin-right: 20px;">Gender</b></label><br>
    <input type="radio" id="male" name="gender" value="male" style="margin-left: 100px;">
    <label for="male" style="margin-right: 50px;  font-family: sans-serif;
  font-size: 12px;">Male</label>
    <input type="radio" id="female" name="gender" value="female">
    <label for="female" style="  font-family: sans-serif;
  font-size: 12px;">Female</label><br><br>

   
    <label for="contact"><b>Contact Number</b></label>
    <input type="text" placeholder="Enter Contact Number" name="contact" id="contact" required>

    <label for="email"><b>Email</b></label>
    <input type="text" placeholder="Enter Email" name="email" id="email" required>

    <label for="psw"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="psw" id="psw" required>

    <label for="psw-repeat"><b>Repeat Password</b></label>
    <input type="password" placeholder="Repeat Password" name="pswrepeat" id="psw-repeat" required>
    <hr>
    
    <button type="submit" class="registerbtn">Register</button>
    <div class="container signin">
    <p>Already have an account? <a href="login.jsp">Sign in</a>.</p>
  </div>
  </div>
  
  
</form>
		</div>
	

</body>
</html>