<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="com.chainsys.model.BankDetails"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
	BankDetails bankDetails = new BankDetails();
	%>
	<div class="header">
		<h1>
			<img alt="" src="images/logo-no-background.png" style="width: 150px;">
		</h1>

	</div>
	<div class="sidebar">

		<a href="#home">Home</a>
		<form action="CustomerDetails.jsp">
			<button class="btn btn secondary" value="submit">Profile</button>
			<!-- <a href="">Account Details</a> -->
		</form>
		<a href="CardPage.jsp">Apply Credit Card</a>
		 <a href="SetPin.jsp">Set
			PIN For Credit Card</a>
		 <a href="#contact">Contact</a>
		<form action="LogoutServlet" method="post">
			<button class="btn btn secondary" value="submit">Logout</button>

		</form>


	</div>


	<%
	ArrayList<BankDetails> values2 = (ArrayList<BankDetails>) request.getAttribute("info");
	for (BankDetails number : values2) {
	%>
	<div class="main-content">
		<div class="card">
			<div class="card-header">Account Number</div>
			<div class="card-content"><%=number.getAccountNumber()%></div>
		</div>
		<div class="card">
			<div class="card-header">Account Type</div>
			<div class="card-content"><%=number.getAccountType()%></div>
		</div>
		<div class="card">
			<div class="card-header">IFSC Code</div>
			<div class="card-content"><%=number.getIfsc()%></div>
		</div>
		<div class="card">
			<div class="card-header">Account Balance</div>
			<div class="card-content"><%=number.getBalance()%></div>
		</div>


		<%
		}
		%>
	</div>


</body>
<style>
button {
	height: 60px;
	font-size: 18px;
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
	/*         padding: 5px;
 */
	text-align: center;
	/*         font-size: 24px;
 */
	position: fixed;
	width: 100%;
	/*         top: 0;
 */
	z-index: 1000;
}

.header h1 {
	margin-top: 6px;
}

.sidebar {
	height: 100%;
	width: 250px;
	position: fixed;
	top: 70px;
	left: 0;
	background-color: rgb(138, 150, 174);
	padding-top: 60px;
	overflow-x: hidden;
}

.sidebar a {
	padding: 15px 20px;
	text-decoration: none;
	font-size: 18px;
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