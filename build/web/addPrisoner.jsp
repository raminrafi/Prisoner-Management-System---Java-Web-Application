<%-- 
    Document   : addPrisoner
    Created on : Dec 27, 2020, 3:03:06 PM
    Author     : abc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- saved from url=(0063)file:///C:/Users/Welcome/Desktop/SE%20Html/Add%20Prisoner.html# -->
<html lang="zxx"><head><meta http-equiv="Content-Type" content="text/html; charset=windows-1252">

<title>Police</title>
<link href="./Add Prisoner_files/bootstrap.css" rel="stylesheet">
<link href="./Add Prisoner_files/bootstrap.min.css" rel="stylesheet">
    <link href="./Add Prisoner_files/font-awesome.min.css" rel="stylesheet">
    <link href="./Add Prisoner_files/animate.min.css" rel="stylesheet">
    <link href="./Add Prisoner_files/prettyPhoto.css" rel="stylesheet">
    
    <link href="./Add Prisoner_files/responsive.css" rel="stylesheet">
    <script src="./Add Prisoner_files/jquery.js.download"></script>
    <link rel="stylesheet" type="text/css" href="./Add Prisoner_files/jquery.dataTables.css">
    <link rel="stylesheet" type="text/css" href="./Add Prisoner_files/dataTables.bootstrap.css">
    <link rel="stylesheet" type="text/css" href="./Add Prisoner_files/dataTables.responsive.css">

    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
    <link href="./Add Prisoner_files/css" rel="stylesheet" type="text/css">
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
  font-size: 15px;
  text-align: left;
  padding: 14px 20px;
  text-decoration: none;
}



/* Change color on hover */
.navbar a:hover {
  background-color: #ddd;
  color: black;
}


/* Column container */
.row {  
  display: -ms-flexbox; /* IE10 */
  display: flex;
  -ms-flex-wrap: wrap; /* IE10 */
  flex-wrap: wrap;
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
 
.button2 {
  margin-left: 240px;
  background-color: red;
} 
.animate
{
  position:relative;animation:animatetop 0.4s
}
  @keyframes animatetop{from{top:-150px;opacity:0} to{top:0;opacity:1}}
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}

      
      body, div, form, input, select, textarea, label, p { 
      padding: 0;
      margin: 0;
      outline: none;
      font-family: Roboto, Arial, sans-serif;
      font-size: 14px;
      color: #666;
      line-height: 22px;
      }
      h1 {
      position: absolute;
      margin-left: 25%;
      font-size: 40px;
      color: Grey;
      z-index: 2;
      line-height: 83px;
      }
      textarea {
      width: calc(100% - 12px);
      padding: 5px;
      }
      .testbox {
      display: flex;
      justify-content: center;
      align-items: center;
      height: inherit;
      padding: 20px;
      }
      form {
      width: 100%;
      padding: 20px;
      border-radius: 6px;
      background: #fff;
      box-shadow: 0 0 8px  #669999; 
      }
      .banner {
      position: relative;
      height: 300px;
      background-image: url("/uploads/media/default/0001/02/c1504011491c4e04e5158b63a27a4ea654b03ed1.jpeg");  
      background-size: cover;
      display: flex;
      justify-content: center;
      align-items: center;
      text-align: center;
      }
      .banner::after {
      content: "";
      background-color: rgba(0, 0, 0, 0.2); 
      position: absolute;
      width: 100%;
      height: 100%;
      }
      input, select, textarea {
      margin-bottom: 10px;
      border: 1px solid #ccc;
      border-radius: 3px;
      }
      input {
      width: calc(100% - 10px);
      padding: 5px;
      }
      input[type="date"] {
      padding: 4px 5px;
      }
      textarea {
      width: calc(100% - 12px);
      padding: 5px;
      }
      .item:hover p, .item:hover i, .question:hover p, .question label:hover, input:hover::placeholder {
      color:  #669999;
      }
      .item input:hover, .item select:hover, .item textarea:hover {
      border: 1px solid transparent;
      box-shadow: 0 0 3px 0  #669999;
      color: #669999;
      }
      .item {
      position: relative;
      margin: 10px 0;
	  margin-left:10px;
	  
	  
      }
      .item span {
      color: red;
      }
      .week {
      display:flex;
      justfiy-content:space-between;
      }
      .colums {
      display:flex;
      justify-content:space-between;
      flex-direction:row;
      flex-wrap:wrap;
      }
      .colums div {
      width:48%;
      }
      input[type="date"]::-webkit-inner-spin-button {
      display: none;
      }
      .item i, input[type="date"]::-webkit-calendar-picker-indicator {
      position: absolute;
      font-size: 20px;
      color:  #a3c2c2;
      }
      .item i {
      right: 1%;
      top: 30px;
      z-index: 1;
      }
      input[type=radio], input[type=checkbox]  {
      display: none;
      }
      label.radio {
      position: relative;
      display: inline-block;
      margin: 5px 20px 15px 0;
      cursor: pointer;
	  
      }
      .question span {
      margin-left: 30px;
      }
      .question-answer label {
      display: block;
      }
      label.radio:before {
      content: "";
      position: absolute;
      left: 0;
      width: 17px;
      height: 17px;
      border-radius: 50%;
      border: 2px solid black;
      }
      input[type=radio]:checked + label:before, label.radio:hover:before {
      border: 2px solid  #669999;
      }
      label.radio:after {
      content: "";
      position: absolute;
      top: 6px;
      left: 5px;
      width: 8px;
      height: 4px;
      border: 3px solid  #669999;
      border-top: none;
      border-right: none;
      transform: rotate(-45deg);
      opacity: 0;
      }
      input[type=radio]:checked + label:after {
      opacity: 1;
      }
      .flax {
      display:flex;
      justify-content:space-around;
      }
      .btn-block {
      margin-top: 10px;
      text-align: center;
	  
      }
      button {
      width: 150px;
      padding: 10px;
      border: none;
      border-radius: 5px; 
      background:  red;
      font-size: 16px;
      color: #fff;
      cursor: pointer;
      }
      button:hover {
      background:  #a3c2c2;
      }
      @media (min-width: 568px) {
      .name-item, .city-item {
      display: flex;
      flex-wrap: wrap;
      justify-content: space-between;
      }
      .name-item input, .name-item div {
      width: calc(50% - 20px);
      }
      .name-item div input {
      width:97%;}
      .name-item div label {
      display:block;
      padding-bottom:5px;
      }
      }
	  
	  .question-answer{
	  color:black;
	  }
	  


     

</style>
</head>
<body style="">

<div class="header">
  <div class="animate"> <img style="width:150px; height: 150px; margin-top: 20px; margin-left: 20px;arg" src="content/images/logo.png" alt="Logo"> 
      </div>
  <h1>Prisoner Management System</h1>  
</div>

<div class="navbar">
  <a href="file:///C:/Users/Welcome/Desktop/SE%20Html/Add%20Prisoner.html#">Back</a>
</div>

    <form method="post" action="addPrisonerServlet">
<h2><b>Personal Information</b></h2>
        
		<div class="colums">
          <div class="item">
            <label for="fname"> First Name<span>*</span></label>
            <input id="fname" type="text" name="fname" required="">
          </div>
		  
		  
          <div class="item">
            <label for="lname"> Last Name<span>*</span></label>
            <input id="lname" type="text" name="lname" required="">
          </div>
        

          <div class="item">
            <label for="address">Address <span>*</span></label>
            <input id="address2" type="text" name="address" required="">
          </div>
		  
		  
		 <div class="question">
          <label>Gender</label>
          <div class="question-answer">
            <div>
              <input type="radio" value="male" id="radio_15" name="gender"/>
              <label for="radio_15" class="radio"><span>Male</span></label>
            </div>
            <div>
              <input  type="radio" value="female" id="radio_16" name="gender"/>
              <label for="radio_16" class="radio"><span>Female</span></label>
            </div>
          </div>
        </div>
		   <div class="item">
            <label for="address2">Age <span>*</span></label>
            <input id="address2" type="text" name="age" required="">
          </div>
		  
		  
	       

		
		</div>
		
<h2><b>Crime Details</b></h2>		
		
       
		
		<div class="colums">
		<div class="item">
            <label for="fname">Reason of Imprisonment<span>*</span></label>
            <input id="fname" type="text" name="reason" required="">
          </div>
		  
		<div class="item">
            <label for="fname">Category<span>*</span></label>
            <input id="fname" type="text" name="category" required="">
          </div>
		  
		  
		   <div class="item">
            <label for="address2">Admit date <span>*</span></label>
            <input id="address2" type="date" name="date" required="">
          </div>


		   <div class="item">
            <label for="address2">Release/ Execution date <span>*</span></label>
            <input id="address2" type="date" name="redate" required="">
          </div>	
		
		</div>
		  
		  
			  <label for="cars">Type of prisoner </label>
			  <select name="type" id="cars">
				<optgroup label="To be executed">
				<option value="Hanging">Hanging</option>
				<option value="Electroucution">Electrocution</option>
				<option value="Firing squad">Firing squad</option>
				<option value="Gas chamber">Gas chamber</option>
				<option value="Lethal injection">Lethal injection</option>
					 
				</optgroup>
				<optgroup label="To be released">
				  <option value="Release">Release</option>
				</optgroup>
			  </select>
  <br><br>
		
		
		
		  <div class="item">
            <label for="address2">Assets <span>*</span></label>
            <input id="address2" type="text" name="asset" required="">
          </div>
		
		
        
       <div class="btn-block">
          <button type="submit">Submit</button>
        </div>
    </form>
    
  

</body></html>