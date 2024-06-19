<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% if(session == null ||session.getAttribute("phone")==null ){
	response.sendRedirect("MainPage.jsp");
}

response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); 
response.setHeader("Pragma", "no-cache"); 
response.setHeader("Expires", "0");
	%>

  <h2>Welcome, <%= session.getAttribute("phone") %></h2>
    <form action="LoginServlet" method="post">
        <button type="submit">LOG OUT</button>
    </form>
   
   
</body>
</html>