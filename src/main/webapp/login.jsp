
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	
	<div class="container d-flex flex-column  align-items-center">
		<h2>Your Account For PetCare</h2>
		<form action="login" method = "post">
			<div class="d-flex flex-column  align-items-center ">
			  <div class="mb-3">
			    <input type="email" class="form-control" placeholder="Username" name="username">
			  </div>
			  <div class="mb-3">
			    <input type="password" class="form-control" placeholder="Password" id="password"  name="password">
			  </div>
				<div class="">
				  <button type="submit" class="btn btn-primary ">Login</button>
			  </div>	
			</div>	
		</form>
		
		<div class="mt-3">
			You are a new member?
			<a href ="signup">Join us here.</a>
			<hr>
			<span class="text-danger">${error}</span>
		</div>
	</div>
	
	<!-- Footer starts -->
	<jsp:include page="layout/footer.jsp" />
	<!-- Footer ends -->
</body>
</html>