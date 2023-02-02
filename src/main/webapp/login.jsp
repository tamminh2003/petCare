
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Log in page</title>
</head>
<body>
	<!-- Header starts -->
	<jsp:include page="layout/header.jsp" />
	<!-- Header ends -->
	
	<h1>LOG IN PETCARE</h1>
	<hr>
	<form action="login" method = "post">
		Username: <input type="text" name="username" /> <br>
		Password: <input type="password" name="password" /> <br>
		<input type="submit" value = "Login"/>
	</form>
	
	<br>
	${error}
	<hr>
	
	<!-- Footer starts -->
	<jsp:include page="layout/footer.jsp" />
	<!-- Footer ends -->
</body>
</html>