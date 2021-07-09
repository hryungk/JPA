<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index Page</title>
</head>
<body>
	<h1>Welcome to the Index Page!</h1>
	<form action="./search" method="POST">
		<div>
			<label>Enter Employee number</label>
			<input type="text" name="employeeNumber">
			<input type="submit" value="Search">
		</div>
	</form>
	<p>Name: ${employee.firstName } ${employee.lastName }</p>
</body>
</html>