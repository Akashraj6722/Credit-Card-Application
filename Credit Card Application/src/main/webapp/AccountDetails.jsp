<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.chainsys.model.BankDetails" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% BankDetails bankDetails = new BankDetails(); %>
 <div class="header">
        Money
    </div>
     <div class="sidebar">

        <a href="#home">Home</a>
         <form action="CustomerDetails.jsp" >
                     <button class="btn btn secondary" value="submit">Profile</button>
                <!-- <a href="">Account Details</a> -->
          </form>
        <a href="#clients">Apply Credit Card</a>
        <a href="#contact">Contact</a>
        <a href="#contact">Logout</a>

    </div> 
    
    
     <%   ArrayList<BankDetails> values2=(ArrayList<BankDetails>)request.getAttribute("info");
    for(BankDetails number:values2){ %>
    <div class="main-content">
        <div class="card">
            <div class="card-header">Account Number</div>
            <div class="card-content"><%=number.getAccountNumber() %></div>
        </div>
        <div class="card">
            <div class="card-header">Account Type</div>
            <div class="card-content"><%=number.getAccountType() %></div>
        </div>
        <div class="card">
            <div class="card-header">IFSC Code</div>
            <div class="card-content"><%=number.getIfsc() %></div>
        </div>
        <div class="card">
            <div class="card-header">Account Balance</div>
            <div class="card-content"><%=number.getBalance() %></div>
        </div>
       
      
         <%} %>
    </div>


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