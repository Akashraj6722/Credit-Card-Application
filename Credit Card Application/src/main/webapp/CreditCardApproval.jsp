<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%@ page import="java.util.ArrayList"%>
<%@ page import="com.chainsys.model.CreditCardDetails"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>Customer's ID</th>
			<th>Account Number</th>
			<th>Credit Card Number</th>
			<th>Credit Card Type</th>
			<th>Credit Card Status</th>
			<th>Credit Card Approval</th>
			<th>Income Proof </th>
		
		</tr>

		<%
		HttpSession se=request.getSession();
		byte[] image=(byte[])se.getAttribute("image");
		ArrayList<CreditCardDetails> list = (ArrayList<CreditCardDetails>) request.getAttribute("values");
		for (CreditCardDetails list1 : list){
		%>


		<tr>
			<td><%=list1.getId()%></td>
			<td><%=list1.getAccountNumber()%></td>
			<td><%=list1.getCardNumber()%></td>
			<td><%=list1.getCardType()%></td>
			<td><%=list1.getCardStatus() %>
			<td><%=list1.getCardApproval()%></td>
			<td><%=image %></td>
			
			<td>
		
			<div class="formAction">
			<form action="AdminServlet" method="get">
		     <input type="hidden" name="action" value= "update">
			 <input type="hidden" name="id" value= "<%=list1.getId()%>">
			 <input type="hidden" name="card" value= "<%=list1.getCardNumber()%>">
			 <button type="submit" value="submit">Approve</button>
			 </form>
			 
			 <form action="AdminServlet" method="get">
			 <input type="hidden" name="action" value= "reject">
			 <input type="hidden" name="id" value= "<%=list1.getId()%>">
			 <input type="hidden" name="card" value= "<%=list1.getCardNumber()%>">
			 <button type="submit" value="submit">Reject</button>
			</form>
			</div>
			</td>
	</tr>
		
		<%} %>
</body>

<style>
.formAction{

display:flex;
gap:45px;


}
* {
	margin: 0%;
	padding: 0%;
	box-sizing: border-box;
}

.box {
	margin-left: 30%;
	margin-top: 5%;
}

body {
	background-color: blanchedalmond;
}

table, th, td {
	border: solid black 2px;
	border-collapse: collapse;
}

th, td {
	padding: 10px;
}

th {
	background-color: #f2f2f2;
}

.delete {
	padding: 10px;
	color: white;
	font-weight: bold;
	background-color: red;
	border: none;
	cursor: pointer;
}

.update {
	padding: 10px;
	color: white;
	font-weight: bold;
	background-color: rgb(32, 219, 32);
	border: none;
	cursor: pointer;
}

a:hover {
	color: black;
}
</style>

</html>