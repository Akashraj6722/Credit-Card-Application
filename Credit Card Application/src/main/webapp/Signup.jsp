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
                <li><a href="MainPage.jsp">Home</a></li>
                

            </ul>
        </div>
        <div class="nav2">
            <h1>SIGNUP</h1>
            <!-- <img src="/ProjectImages/image.png" alt="" style="width: 40px;"> -->
        </div>
        <div class="nav3">
            <ul>
                <li><a href="#">Help</a></li>
              
            </ul>
        </div>

    </div>

    <div class="box">
        <form action="BankServlet" method="post" onsubmit="return validatePassword()">
            <div class="row">


                <div class="column1">
                    <ul>
                        <li> <label class="fName" for="fName">First Name:</label></li><br>
                        <li><label class="lName " for="lName">Last Name: </label></li><br>
                        <li> <label class="DOB " for="DOB">Date.Of.Birth:</label></li><br>
                        <li> <label for="aadhaar" class="aadhaar">Aadhaar Number:</label></li><br>
                        <li> <label for="pan" class="pan">PAN Number:</label> </li><br>
                        <li> <label for="mail" class="mail">Email:</label></li><br>
                        <li> <label for="ph" class="phone">Phone Number:</label></li><br>
<!--                         <li><label for="accountType" class="accountType">Account Type</label></li><br>
 -->                    <li> <label for="pass" class="pass">Password:</label></li><br>
                        <li> <label for="repass" class="repass">Confirm Password:</label></li><br>

                    </ul>
                </div>

                <div class="column2">
                    <ul>
                        <li><input type="text" id="fName" name="fName" placeholder="Enter Your FirstName" required></li><br>
                        <li><input type="text" id="lName" name="lName"  placeholder="Enter Your LastName" required></li><br>
                        <li> <input type="date" id="DOB" name="DOB"  required></li><br>
                        <li><input type="text" id="aadhaar" name="aadhaar"  placeholder="Enter  Aadhaar Number" pattern="[0-9]{12}" required></li><br>
                        <li><input type="text" id="pan" name="pan"  placeholder="Enter  PAN Number" pattern="[A-Z]{5}[0-9]{4}[A-Z]{1}" required></li><br>
                        <li><input type="text" id="mail" name="mail"  placeholder="Enter Your Mail-id" pattern="[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+[com]$" required ></li><br>
                        <li><input type="tel" id="ph" name="ph"  placeholder="+91" pattern="[0-9]{10}" required ></li><br>
                       <!--  <li><select  name="accountType" id="accountType">
                              <option value="Select"> Select Any One </option>
                              <option value="Savings Account">Savings Account</option>
                              <option value="Current Account">Current Account</option>
                           </select></li><br> -->
                           
                        <li><input type="text" id="pass" name="pass" placeholder="Atleast 8 Characters" pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()_+.])(?=.*\\d).{8,}$"required ></li><br>
                        <li><input type="text" id="repass" name="repass" placeholder="Re-Enter Password" required ></li><br>

                    </ul>
                </div>

            </div>
            <div class="submit">
                <button type="submit">SUBMIT</button>

            </div>

        </form>
    </div>
    
    <script>
        function validatePassword(){

            var password= document.getElementsByName("fName").value;
            console.log(password);
            var rePassword= document.getElementsByName("repass").value;

            if(password!=rePassword){
               
                alert ("Passwords dont match");
                return false;
            }
            return true;

        }
    </script>
</body>

<style>
    .nav{
    display: flex;
    justify-content: space-between;
    
}

    .nav ul {
        list-style-type: none;
        margin: 0;
        padding: 0;
    }

    
    

    .nav2{
        font-family:Arial, Helvetica, sans-serif;
        margin-top:10px;
    }


    .nav ul li a {
        font-size: 25px;
        display: block;
        color: rgb(0, 0, 0);
        padding: 14px 16px;
        text-decoration: none;
    }

    .nav ul li a:hover {
        background-color: #555;
    }
    body{
        background-image: url(/ProjectImages/Moneymate_Bestcreditcardstudents.webp);
        background-repeat: no-repeat;
        background-size: 1800px;

    }
    .DOB {
        margin-top: 40px;
    }

     .column1 label .fName{
             margin-top: 48px;
     
     }
    
    #fName {
        margin-top: 48px;
    }

    .box {
        border: 2px solid;
        box-shadow: 4px 4px 4px;
        width: 380px;
        height: 420px;
        justify-content: center;


    }

    .row {
        margin-top: 13%;
    
        height: 45vh;
        display: flex;
        justify-content: center;
        align-items: center;
        gap: 20px;
    }

    .submit {
        display: flex;
        justify-content: center;
        margin-top: 78px;

    }
     
    .column1 ul li {
        font-weight: bold;
        
    }

    .column2 ul,
    .column1 ul {

        list-style: none;
    }


    .box {
        display: flex;
        margin-left: 15%;
        margin-top: 7%;
    }

    * {
        padding: 0px;
        margin: 0px;
        box-sizing: border-box;
    }

    .navbar {
        display: flex;
        height: 15vh;
        justify-content: center;
        color: aliceblue;
        background-color: rgb(150, 26, 26);
    }

    .navbar h1 {
        margin-top: 30px;
    }
</style>
</html>