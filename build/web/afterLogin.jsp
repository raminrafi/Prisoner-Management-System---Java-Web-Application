<%-- 
    Document   : afterLogin
    Created on : Dec 27, 2020, 3:02:36 PM
    Author     : abc
--%>

<%@page import="java.util.*"%>
<%@page import="newpackage.*"%>
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

tr:nth-child(even)
{
  background-color: #f2f2f2;
}

tr:hover 
{
  background-color: #ddd;
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
  margin-left:30px;
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
  margin-left: 1125px;
  background-color: green;
} 
 
.button2 {
  margin-left: 1225px;
  background-color: red;
} 
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
td {
  padding: 8px;
  border: 1px solid #ddd;
}
th {
  text-align: center;
  padding-top: 12px;
  padding-bottom: 12px;
  padding-left:8px;
  text-align: left;
  background-color: #333;
  color: white;
  border: 1px solid #ddd;
}

@media screen and (max-width: 700px) {
  .row {   
    flex-direction: column;
    text-align: left;
    margin-top:30px;
    margin-bottom:500px;
    margin-left:20px;
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
  <a class="button button2" href="login.jsp">SignOut</a>
</div>

<div class="row">
  <div class="side">
  <h2> Prisoner's Lists
      <a class="button button1" href="addPrisoner.jsp">Add new prisoner</a>
  </h2>
      <form method="post" action="afterLoginServlet">
  <table style="width:100%">
  <tr>
    <th>Id</th>
    <th>Name</th> 
    <th>Type</th>
  </tr>
  <%PMS obj=PMS.getInstance();
    ArrayList<Prisoner> p=obj.getPrisoners();
    
for(int i=0;i<p.size();i++)
{%>
<tr>
    
    <td><input type="submit" name="id" value="<%=p.get(i).getID()%>"></td>
    <td><%=p.get(i).getFirstName()%></td>
    <td><%=p.get(i).getTypeOfPrisoner()%></td>
</tr>
<%}%>

</table>
      </form>
</div>


</body>
</html>
