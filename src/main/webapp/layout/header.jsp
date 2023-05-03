<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
</head>
<body>
	<div class="container-fluid pt-4">

		<div class="row pb-3">
			<div class="container ps-5">
				<div class="row">
					<div class="col-6">

						<a href="/pet-care/BookingServlet">
							<button type="button" class="btn btn-primary">Book
								Appointment</button>
						</a>

					</div>
					<div class="col">
						<div>1068 Victoria Road</div>
						<div>West Ryde 2114</div>
					</div>
					<div class="col">
						<div>Phone</div>
						<div>(02) 1234 1234</div>
					</div>
				</div>

			</div>

		</div>

		<div class="row bg-body-tertiary ps-5 pe-5">

			<nav class="navbar navbar-expand bg-body-tertiary">
				<div class="container-fluid">
					<a class="navbar-brand" href="#"> <img alt=""
						src="public/images/petcare-logo.png" class="w-25">
					</a>

					<div class="collapse navbar-collapse" id="navbarSupportedContent">
						<ul class="navbar-nav me-auto mb-2 mb-lg-0">
							<li class="nav-item"><a class="nav-link active"
								aria-current="page" href="/pet-care/home">Home </a></li>

							<li class="nav-item"><a class="nav-link active"
								aria-current="page" href="#">Services </a></li>

							<li class="nav-item"><a class="nav-link active"
								aria-current="page" href="#">Shops </a></li>
							<li class="nav-item"><a class="nav-link active"
								aria-current="page" href="/pet-care/BookingServlet">Bookings
							</a></li>
							<li class="nav-item"><a class="nav-link active"
								aria-current="page" href="#">Contact Us </a></li>
						</ul>

						<div class="navbar-text">
							<c:if test="${firstname != null }">
								<span class="mx-3">Welcome back, ${firstname}</span>
							</c:if>
							<c:choose>
								<c:when test="${firstname == null}">
									<a href="login">
										<button type="button" class="btn btn-primary">Log In</button>
									</a>
								</c:when>
								<c:otherwise>
									<a href="logout">
										<button type="button" class="btn btn-primary">Log Out</button>
									</a>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</div>
			</nav>

		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
		crossorigin="anonymous"></script>


	<script>
		function handleClickBooking() {
			console.log("Booking clicked");
		}
	</script>
</body>
</html>