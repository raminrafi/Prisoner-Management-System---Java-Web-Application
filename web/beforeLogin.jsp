<%-- 
    Document   : beforeLogin
    Created on : Dec 27, 2020, 3:02:12 PM
    Author     : abc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Page Title</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
* {
  box-sizing: border-box;
}

/* Style the body */
body {
  font-family: Arial, Helvetica, sans-serif;
  margin: 0;
  background-color: lightgrey;
}

/* Header/logo Title */
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

.navbar {
  overflow: hidden;
  background-color: #333;
  position: sticky;
  position: -webkit-sticky;
  top: 0;
  
}

/* Style the navigation bar links */
.navbar a {
  float: left;
  display: block;
  color: white;
  text-align: center;
  padding: 14px 20px;
  text-decoration: none;
}

/* Right-aligned link */
.navbar a.right {
  float: right;
}

/* Change color on hover */
.navbar a:hover {
  background-color: #ddd;
  color: black;
}

/* Active/current link */
.navbar a.active {
  background-color: #666;
  color: white;
}

/* Column container */
.row {  
  display: -ms-flexbox; /* IE10 */
  display: flex;
  -ms-flex-wrap: wrap; /* IE10 */
  flex-wrap: wrap;
  margin-left:10px;
  text-align:center;
  font-size: 24px; 
  font-variant:small-caption;
}



/* Create two unequal columns that sits next to each other */
/* Sidebar/left column */
.side {
  -ms-flex: 30%; /* IE10 */
  flex: 30%;
  background-color: white;
  padding: 20px;
  font:sans-serif;
  font-variant:small-caps;
  font:Arial;
  text-align: center;
  margin-left:100px;

}

/* Main column */
.main {   
  -ms-flex: 70%; /* IE10 */
  flex: 70%;
  background-color: white;
  padding: 20px;
}

.button {
  border: none;
  color: white;
  padding: 12px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 3px 3px;
  cursor: pointer;
  width: fit-content;
}

.button1 {
  background-color: #4CAF50;
  margin-left:830px;
} 
.button2 {
  background-color: red;
} 

@media screen and (max-width: 700px) {
  .row {   
    flex-direction: column;
    text-align: center;
    margin-top:75px;
    margin-bottom:800px;
	margin-left:30px;
  }
}

@media screen and (max-width: 400px) {
  .navbar a {
    float: none;
    width: 100%;
  }
}
.animate
{
  position:relative;animation:animatetop 0.4s
}
  @keyframes animatetop{from{top:-150px;opacity:0} to{top:0;opacity:1}}
</style>
</head>
<body>

<div class="header">
  <div class="animate" > <img style="width:150px; height: 150px; margin-top: 20px; margin-left: 20px;arg" src="content/images/logo.png" alt="Logo" style="max-width: 300px;"> 
      </div>
  <h1>Prisoner Management System</h1>  
</div>

<div class="navbar">
  <a href="#" class="active">Home</a>
  <a href="#">About</a>
  <a href="#">Contact Us</a>
  <a class="button button1" href="login.jsp">Login</a>
  <a class="button button2" href="signup.jsp">SignUp</a>
</div>

<div class="row">
  <div class="side">
  <h2> Care, Custody and Control</h2>
  <p>Introduction of modern IT Technologies in Prisons is a need of the hour in order to infuse efficiency in daily systematic treatment of prisoners' data for fast retrieval of the required information.</p>
  </div>  
</div>


</body>
</html>
