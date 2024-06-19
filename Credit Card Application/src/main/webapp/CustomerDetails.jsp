<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="com.chainsys.model.Details"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">

<title>Insert title here</title>
</head>
<body>
	<%
	if (session == null || session.getAttribute("email") == null) {
		response.sendRedirect("MainPage.jsp");
	}

	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");
	%>
	<%
	Details details = new Details();
	%>
	<div class="header">

		
			<img alt="" src="images/logo-no-background.png" style="width: 150px;">
		

	</div>
	<div class="sidebar">

		<a href="#home"><i class="fa-solid fa-house"></i>Home</a>

		<form action="LoginServlet" method="get">
			<button class="btn btn secondary" value="submit"><i class="fa-solid fa-file-invoice"></i>Account
				Details</button>

		</form>

		<a href="CardPage.jsp"><i class="fa-regular fa-credit-card"></i>Apply Credit Card</a>
		
		 <a href="SetPin.jsp"><i class="fa-solid fa-key"></i>Set
			PIN For Credit Card</a> 
			
		<a href="#contact"><i class="fa-solid fa-tty"></i>Contact</a>

		<form action="LogoutServlet" method="post">
			<button type="submit" value="submit"><i class="fa-solid fa-right-from-bracket"></i>Logout</button>

		</form>

	</div>
	<%
	HttpSession sessio = request.getSession();
	%>
	<%
	ArrayList<Details> values1 = (ArrayList<Details>) sessio.getAttribute("values");
	for (Details display : values1) {
	%>


	<div class="main-content">
		<div class="card">
			<div class="card-header">Name</div>
			<div class="card-content"><%=display.getfName()%>
				<%=display.getlName()%></div>
		</div>

		<div class="card">
			<div class="card-header">Customer Id</div>
			<div class="card-content"><%=display.getCustomerID()%></div>
		</div>
		<div class="card">
			<div class="card-header">Aadhaar Number</div>
			<div class="card-content"><%=display.getAadhaar()%></div>
		</div>
		<div class="card">
			<div class="card-header">PAN</div>
			<div class="card-content"><%=display.getPan()%></div>
		</div>
		<div class="card">
			<div class="card-header">Phone Number</div>
			<div class="card-content"><%=display.getPhone()%></div>
		</div>
		<%
		}
		%>
	</div>
	<%-- <% ArrayList<Details> info=(ArrayList<Details>)request.getAttribute("info"); 
	request.setAttribute("info1", info);
	
	request.getRequestDispatcher("AccountDetails.jsp").forward(request, response);

 
      %> --%>

</body>
<style>

i{
padding-right:10px;
}
body, html {
	margin: 0;
	padding: 0;
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
}

.header {
	background-color: rgb(20, 136, 236);
	color: #fff;
	height: 75px;
	text-align: center;
	position: fixed;
	width: 100%;
	z-index: 1000;
}

.header h1 {
	margin-top: 6px;
	margin-left:50px;
}

button {
	height: 60px;
	/* margin-left:12px; */
	font-size: 17px;
	background-color: rgb(138, 150, 174);
	color: white;
	border: 0;
	cursor: pointer;
	width: 250px;
	height: 50px;
	text-align: justify;
	padding: 15px 20px;
}

button:hover {
	background-color: #575757;
}

.sidebar {
	height: 100%;
	width: 250px;
	position: fixed;
	top: 60px;
	left: 0;
	background-color: rgb(138, 150, 174);
	padding-top: 60px;
	overflow-x: hidden;
}

.sidebar a {
	padding: 15px 20px;
	text-decoration: none;
	font-size: 17px;
	color: white;
	display: block;
}

.sidebar a:hover {
	background-color: #575757;
}

.main-content {
	margin-left: 260px;
	padding: 20px;
	padding-top: 80px;
	background-color: #f4f4f4;
	min-height: 100vh;
}

.card {
	background-color: #fff;
	padding: 20px;
	margin: 15px 0;
	box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
	border-radius: 5px;
}

.card-header {
	font-size: 20px;
	margin-bottom: 10px;
}

.card-content {
	font-size: 16px;
}


.button:hover {
	background-color: #005f73;
}

@media screen and (max-width: 768px) {
	.sidebar {
		width: 100%;
		height: auto;
		position: relative;
	}
	.sidebar a {
		float: left;
	}
	.main-content {
		margin-left: 0;
		padding-top: 140px;
	}
}
</style>
</html>