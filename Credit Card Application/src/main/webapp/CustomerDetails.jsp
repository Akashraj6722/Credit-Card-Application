<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.chainsys.model.Details" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% Details details = new Details(); %>
 <div class="header">
        Money
    </div>
    <div class="sidebar">

        <a href="#home">Home</a>
        
        <form action="LoginServlet" method="get">
                     <button class="btn btn secondary" value="submit">Account Details</button>
                <!-- <a href="">Account Details</a> -->
          </form>
        
        <a href="CardPage.jsp">Apply Credit Card</a>
        <a href="SetPin.jsp">Set PIN For Credit Card</a>
        <a href="#contact">Contact</a>
        <a href="MainPage.jsp">Logout</a>

    </div>
    <% HttpSession sessio = request.getSession(); %>
    <% ArrayList<Details> values1=(ArrayList<Details>) sessio.getAttribute("values"); 
     for(Details display:values1){ %>
    
    
    <div class="main-content">
        <div class="card">
            <div class="card-header">Name</div>
            <div class="card-content"><%=display.getfName()%> <%= display.getlName() %></div>
        </div>

        <div class="card">
            <div class="card-header">Customer Id</div>
            <div class="card-content"><%=display.getCustomerID() %></div>
        </div>
         <div class="card">
            <div class="card-header">Aadhaar Number</div>
            <div class="card-content"><%=display.getAadhaar() %></div>
        </div>
        <div class="card">
            <div class="card-header">Pan Number</div>
            <div class="card-content"><%=display.getPan() %></div>
        </div>
        <div class="card">
            <div class="card-header">Phone Number</div>
            <div class="card-content"><%=display.getPhone() %></div>
        </div>
         <%} %>
    </div>
 <%-- <% ArrayList<Details> info=(ArrayList<Details>)request.getAttribute("info"); 
	request.setAttribute("info1", info);
	
	request.getRequestDispatcher("AccountDetails.jsp").forward(request, response);

 
      %> --%>

</body>
<style>
    body,
    html {
        margin: 0;
        padding: 0;
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
    }

    .header {
        background-color: rgb(20, 136, 236);
        color: #fff;
        padding: 15px;
        text-align: center;
        font-size: 24px;
        position: fixed;
        width: 100%;
        top: 0;
        z-index: 1000;
    }


    .sidebar {
        height: 100%;
        width: 250px;
        position: fixed;
        top: 60px;
        left: 0;
        background-color: rgb(138, 150, 174);
        padding-top: 20px;
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
</html>