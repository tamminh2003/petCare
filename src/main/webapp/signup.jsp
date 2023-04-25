
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
	
	<div class="container d-flex flex-column  align-items-center">
		<h2>New Account</h2>
		<form action="signup" method = "post">
			<div class="d-flex flex-column  align-items-center ">
			  <div class="mb-3">
			    <input type="text" class="form-control" placeholder="First Name" name="firstname">
			  </div>
			  <div class="mb-3">
			    <input type="text" class="form-control" placeholder="Last Name"  name="lastname">
			  </div>
			    <div class="mb-3">
			    <input type="text" class="form-control" placeholder="Phone Number"  name="phoneNumber">
			  </div>
			   <div class="mb-3">
			    <input type="email" class="form-control" placeholder="Email"  name="email">
			  </div>
			   
			     <div class="mb-3">
			    <input type="password" class="form-control" placeholder="Password"  name="password">
			  </div>
				<div class="">
				  <button type="submit" class="btn btn-primary ">Create New Account</button>
			  </div>	
			</div>	
		</form>
		
		
	<br>
	${error}
		
	</div>

	
	<!-- Footer starts -->
	<jsp:include page="layout/footer.jsp" />
	<!-- Footer ends -->
</body>
</html>