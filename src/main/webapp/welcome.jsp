<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
    <h1>Hello ${sessionScope.username}!</h1>
    <p>Debug: Session Username is [${sessionScope.username}]</p>
    
    <form action="logout" method="get">
    <input type="submit" value="Logout">
	</form>
    
</body>
</html>
