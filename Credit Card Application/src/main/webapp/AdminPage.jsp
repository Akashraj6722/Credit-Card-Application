<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
	<div class="header">
	
			<img alt="" src="images/logo-no-background.png" style="width: 150px;">
		

	</div>
	<div class="sidebar">

		<a href="AdminPage.jsp">Home</a> <a href="#contact">Contact</a> <a
			href="MainPage.jsp">Logout</a>

	</div>


	<div class="main-content">
		<div class="card">
			<form action="AdminServlet" method="post">
				<button class="btn btn secondary" value="submit">To
					Approve/reject Customer's Credit Card</button>
			</form>
		</div>

	</div>
</html>
</body>
<style>
.header {
	background-color: rgb(20, 136, 236);
	color: #fff;
	height: 75px;
	text-align: center;
	position: fixed;
	width: 100%;
	top: 0;
	z-index: 1000;
}

.header  {
	margin-top: 6px;
}

body, html {
	margin: 0;
	padding: 0;
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
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
	padding-top: 100px;
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

.button {
	background-color: #333;
	color: white;
	padding: 10px 20px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	font-size: 16px;
	text-align: center;
	text-decoration: none;
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