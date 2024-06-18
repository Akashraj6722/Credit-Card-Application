<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div class="details">
		<form action="CardServlet" method="post" enctype="multipart/form-data">
			<h2>Credit Card Application Form</h2>
			<div class="form-group">
				<label for="occupation">Occupation:</label> <input type="text"
					id="occupation" name="occupation" required>
			</div>
			<div class="form-group">
				<label for="company-name">Company Name:</label> <input type="text"
					id="company-name" name="companyName" required>
			</div>
			<div class="form-group">
				<label for="designation">Designation:</label> <input type="text"
					id="designation" name="designation" required>
			</div>
			<div class="form-group">
				<label for="annual-income">Annual Income:</label> <input
					type="number" id="annual-income" name="annualIncome" step="100000"
					required>
			</div>
			<input type="file" name="incomeProof" accept="/image*" required>

			<button type="submit">Submit</button>
		</form>
	</div>
	</div>
</body>


<style>
.header {
	background-color: rgb(20, 136, 236);
	color: #fff;
	padding: 25px;
	text-align: center;
	font-size: 24px;
	/* position: fixed; */
	width: 100%;
}

body {
	font-family: Arial, sans-serif;
	background-color: #f7f7f7;
	margin: 0;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
}

.form-container {
	background-color: #fff;
	padding: 20px;
	border-radius: 8px;
	box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
	width: 300px;
}

form {
	display: flex;
	flex-direction: column;
}

h2 {
	/* margin-bottom: 20px; */
	color: #333;
}

.form-group {
	margin-bottom: 15px;
}

label {
	display: block;
	/* margin-bottom: 5px; */
	color: #666;
}

input {
	width: 100%;
	padding: 8px;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

button {
	padding: 10px;
	background-color: rgb(20, 136, 236);
	color: #fff;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	font-size: 16px;
}

button:hover {
	background-color: rgb(15, 94, 164);
}
</style>


</html>