<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
	ArrayList<Details> list = (ArrayList<Details>) request.getAttribute("rs");
	%>

	<div class="box">
		<table>
			<tr>
				<th>id</th>
				<th>account_number</th>
				<th>account_type</th>
				<th>account_status</th>
				<th>Action</th>
			</tr>
			<%
			if (list != null && !list.isEmpty()) {
				for (Details values : list) {
			%>
			<tr>
				<td><%=values.getName()%></td>
				<td><%=values.getPhone()%></td>
				<td><%=values.getMail()%></td>
				<td>
					<form action="NewServlet" method="post"
						onsubmit="return confirm('Are you sure you want to Edit?');">
						<input type="hidden" name="action" value="update"> <input
							type="hidden" name="editId" value="<%=values.getId()%>">

						<button class="update" type="submit"
							onclick="location.href='UpdateForms.jsp?id=<%=values.getId()%>'">Update</button>
				</td>


			</tr>
			<%
			}
			} else {
			%>
			<tr>
				<td colspan="4">No details found.</td>
			</tr>
			<%
			}
			%>
		</table>
	</div>


</body>
<style>
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

</html> --%>