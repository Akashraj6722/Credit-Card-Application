<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>

    <div class="nav" style="background-color: rgb(20, 136, 236);">

        <div class="nav1">
            <ul>
                <li><a href="#">Home</a></li>
                <li><a href="#">Who We Are</a></li>
                <li><a href="#">Help</a></li>

            </ul>
        </div>
        <div class="nav2">
            <img src="/ProjectImages/image.png" alt="" style="width: 40px;">
        </div>
        <div class="nav3">
            <ul>
                <li><a href="Signup.jsp">SIGN-UP</a></li>
                <li><a href="Login.jsp">LOGIN</a></li>
                <li><a href="www.instagram.com"><i class="fa-brands fa-instagram "></i></a></li>
                <li><a href="www.twitter.com"><i class="fa-brands fa-x-twitter"></i></i></a></li>
                <li><a href="www.facebook.com"><i class="fa-brands fa-facebook"></i></a></li>
                
            </ul>
        </div>

    </div>

    <div class="slider">
        <div class="slides">
            <div class="slide"><img src="slidebar1.webp" alt="Screenshot 108"></div>
            <div class="slide"><img src="/ProjectImages/slidebar1.webp" alt="Screenshot 107" style="width: 1228px ; height: 600px;"></div>
            <div class="slide"><img src="/ProjectImages/slidebar3.webp" alt="Screenshot 108"></div>

         
        </div>
    </div>
      
    

</body>

<style>

.slider {
    width:1228px ;
    height: 540px;

    /* margin: 50px auto; */
    overflow: hidden;
    border: 2px solid #ddd;
    /* border-radius: 10px; */
}

.slides {
    display: flex;
    /* width: 200%; */
    animation: slide 10s infinite;
}

.slide {
    width: 100%;
    flex:  1 0  100%;
}

.slide img {
    width: 100%;
    display: block;
}

@keyframes slide {
    0% { transform: translateX(0); }
    40% { transform: translateX(-100%); }
    100% { transform: translateX(0); }
}

    .nav3  a,.nav1 a{
       height: 25px;
        font-size: 20px;

    }
    .nav3 i{
        font-size: 25px;
    }
    .nav2{
        /* float: left; */
        /* margin-left: 30PX; */
        width: 0;
    }
    body {
        margin: 0;
        box-sizing: border-box;
        padding: 0%;
        font-family: Arial, sans-serif;
        background-color: white
    }

.nav{
    display: flex;
    justify-content: space-between;
    /* height: 60px; */
}

    .nav ul {
        list-style-type: none;
        margin: 0;
        padding: 0;
    }

    .nav1 ul {
        display: flex;

        /* float: left; */
    }
    

    .nav2{
        margin-top: 6px;
        margin-left: -400px;
    }

    .nav3 ul  {
        display: flex;
        
        /* float: left; */

        /* float: right; */
    }

    .nav ul li a {
        display: block;
        color: rgb(0, 0, 0);
        padding: 14px 16px;
        text-decoration: none;
    }

    .nav ul li a:hover {
        background-color: #555;
    }
</style>