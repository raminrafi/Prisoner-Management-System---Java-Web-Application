<%-- 
    Document   : login
    Created on : Dec 27, 2020, 2:20:58 PM
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

body {font-family:sans-serif;}


input[type=text], input[type=password] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}
.container {
  padding: 16px;
  background-color: white;
  margin-bottom: 18px;
  width: 50%;
}
.login {
  background-color: red;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  font-size: 15px;
  font-family: sans-serif;
}

.login:hover {
  opacity: 0.8;
}
label
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
      <form method="post" action="loginServlet">
  

  <div class="container">
    <label for="uname"><b>Email</b></label>
    <input type="text" placeholder="Enter Email" name="email" required>

    <label for="psw"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="psw" required>
        
    <button class="login" type="submit">Login</button>
    <label>
      <input type="checkbox" checked="checked" name="remember"> Remember me
    </label>
    <div class="container signin">
    <p>Don't have an account? <a href="signup.jsp">Register</a>.</p>
  </div>
  </div>

 
</form>
		</div>
	

</body>
</html>