<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.chainsys.model.CreditCardDetails" %>
    <%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%

 CreditCardDetails preview = new CreditCardDetails();

ArrayList<CreditCardDetails> list=(ArrayList<CreditCardDetails>)request.getAttribute("values");
for(CreditCardDetails list1:list){
	
	String numberString=list1.getCardNumber();

	
	 if (numberString.length() == 16) {
         String[] parts = numberString.split("(?<=\\G.{4})");
         
         
//         for (int i = 0; i < 4; i++) {
//             System.out.println("Group " + (i + 1) + ": " + parts[i]);
//         }
         String part1 = parts[0];
         String part2 = parts[1];
         String part3 = parts[2];
         String part4 = parts[3];
         
         System.out.println("Part 1: " + part1);
         System.out.println("Part 2: " + part2);
         System.out.println("Part 3: " + part3);
         System.out.println("Part 4: " + part4);
         
         PrintWriter outs = response.getWriter();

%>


	<div class="card-silver">
		<div class="card-inner-silver">
			<div class="front-silver">
				<img src="" class="map-img">
				<div class="row">
					<img src="https://i.ibb.co/G9pDnYJ/chip.png" width="50px"> <img
						src="/ProjectImages/Rupay-Logo.png" width="80px">
				</div>
				<div class="row card-no-silver">
					<p><%= part1 %></p>
					<p><%= part2  %></p>
					<p><%= part3 %></p>
					<p><%= part4%></p>
				</div>
				<div class="row card-holder-silver">
					<p>CARD HOLDER</p>
					<p>VALID TILL</p>
				</div>
				<div class="row name-silver">
					<p><%= list1.getHolderName() %></p>
					<p><%= list1.getValidity() %></p>
				</div>
			</div>
			<div class="back-silver">
				<img src="" class="map-img">
				<div class="bar"></div>
				<div class="row card-cvv-silver">
					<div>
						<img src="https://i.ibb.co/S6JG8px/pattern.png" width="200px">
					</div>
					<p><%= list1.getCvvNumber() %></p>

				</div>
				<div class="row card-text-silver">
					<p>details</p>
				</div>
				<div class="row signature-silver">
					<p>CUSTOMER SIGNATURE</p>
					<img src="https://i.ibb.co/WHZ3nRJ/visa.png" width="50px">
				</div>
			</div>
		</div>
	</div>
<%
	 }
	 
	 }%>

</body>

<style>

.card-silver,
    .card-gold,
    .card-platinum,
    .card-elite {
        margin-top: 30px;
       margin-left: 200px;
        width: 350px;
        height: 200px;
        color: #fff;
        cursor: pointer;
        perspective: 1000px;
    }

    .card-inner-silver,
    .card-inner-gold,
    .card-inner-platinum,
    .card-inner-elite {
        width: 100%;
        height: 100%;
        position: relative;
        transition: transform 1s;
        transform-style: preserve-3d;
    }

    .front-silver,
    .back-silver,
    .front-gold,
    .back-gold,
    .front-platinum,
    .back-platinum,
    .front-elite,
    .back-elite {
        width: 100%;
        height: 100%;
        background-image: linear-gradient(45deg, #635c5c, #a79ca0);
        position: absolute;
        top: 0;
        left: 0;
        padding: 20px 30px;
        border-radius: 15px;
        overflow: hidden;
        z-index: 1;
        backface-visibility: hidden;
    }

    .row {
        display: flex;
        align-items: center;
        justify-content: space-between;
    }

    .map-img {
        width: 100%;
        position: absolute;
        top: 0;
        left: 0;
        opacity: 0.3;
        z-index: -1;
    }

    .card-no-silver {
        font-size: 20px;
        margin-top: 20px;
    }

    .card-holder-silver {
        font-size: 10px;
        margin-top: 20px;
    }

    .name {
        font-size: 15px;
        margin-top: 15px;
    }

    .bar {
        background: #222;
        margin-left: -30px;
        margin-right: -30px;
        height: 30px;
        margin-top: 1px;
    }

    .card-cvv-silver {
        margin-top: 10px;
    }

    .card-cvv-silver img {
        width: 100%;
        display: block;

    }

    .card-cvv-silver p {
        background: #fff;
        color: #000;
        font-size: 15px;
        padding: 9px 8px;
    }

    .card-text-silver {
        margin-top: 5px;
        font-size: 10px;
    }

    .signature-silver {
        margin-top: 40px;
    }

    .back-silver {
        transform: rotateY(180deg);
    }

    .card-silver:hover .card-inner-silver {
        transform: rotateY(-180deg);
    }


</style>
</html>