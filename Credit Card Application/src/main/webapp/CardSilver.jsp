<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <div class="align">
        <div class="box">
            <div class="container">
                <div class="card-silver">
                    <div class="card-inner-silver">
                        <div class="front-silver">
                            <img src="" class="map-img">
                            <div class="row">
                                <img src="https://i.ibb.co/G9pDnYJ/chip.png" width="50px">
                                <img src="https://i.ibb.co/WHZ3nRJ/visa.png" width="50px">
                            </div>
                            <div class="row card-no-silver">
                                <p>xxxx</p>
                                <p>xxxx</p>
                                <p>xxxx</p>
                                <p>xxxx</p>
                            </div>
                            <div class="row card-holder-silver">
                                <p>CARD HOLDER</p>
                                <p>VALID TILL</p>
                            </div>
                            <div class="row name-silver">
                                <p>AKASH RAJ</p>
                                <p>10 / 25</p>
                            </div>
                        </div>
                        <div class="back-silver">
                            <img src="" class="map-img">
                            <div class="bar"></div>
                            <div class="row card-cvv-silver">
                                <div>
                                    <img src="https://i.ibb.co/S6JG8px/pattern.png" width="200px">
                                </div>
                                <p>824</p>

                            </div>
                            <div class="row card-text-silver">
                                <p>this is a virtual card design using HTML and CSS. You can aslo design something like
                                    this.
                                </p>
                            </div>
                            <div class="row signature-silver">
                                <p>CUSTOMER SIGNATURE</p>
                                <img src="https://i.ibb.co/WHZ3nRJ/visa.png" width="50px">
                            </div>
                        </div>
                    </div>
                </div>

                <div class="word"><br>
                    <h3>SBI Card SILVER Advantage</h3><br>
                    <ul>
                        <li>Welcome e-Gift Voucher worth Rs. 5,000 on joining</li><br>
                        <li>Get free movie tickets worth Rs. 6,000 every year</li><br>
                        <li>Earn upto 50,000 Bonus Reward Points worth 
                            Rs. 12,500/year</li><br>
                        <li>Complimentary membership to Club Vistara and  Trident Privilege program</li><br>
                    </ul>
                </div>
                <div class="apply">
                    <a href="CardForms.jsp">Check Eligibility</a>
                </div>
            </div>
        </div>

</body>
<style>
    .word{
        /* margin-left: -250px; */
        margin-top: 20px;
    }
    .align{
        display: flex;
        justify-content: center;
    }
    .apply a {

        text-decoration: none;
        padding: 5px;
        border: 1px solid;
        color: #000;

    }

    .apply a:hover{
        color: white;
        background-color: blue;
    }

    .apply {
        display: flex;
        justify-content: end;
        margin-left: 700px;
        margin-top: 40px;
       
    }

    * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
        font-family: 'Josefin Sans', sans-serif;
    }

    body {
        background-color: rgb(255, 255, 255);

    }

    .box {
        margin-left: 10px;
        margin-top: 10px;
        display: flex;
        justify-content: center;
        border: 1px solid;
        box-shadow: 2px 2px 2px;
        width: 950px;
        height: 550px;
        border-radius: 20px;
    }

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
</body>
</html>