<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PetCare Vet Clinic</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
</head>
<body>

	<!-- Header starts -->
	<jsp:include page="layout/header.jsp" />
	<!-- Header ends -->

	<div class="container ">

		<div class="container border border-dark border-1 p-3 m-3 position-relative">
			<div class="row">
				<form action="BookingDetailServlet">
					<div class="mb-3">
						<label for="customerName" class="form-label">Your
							Name</label> 
							 <input type=text class="form-control mb-2"
							id="firstName" name="firstName" placeholder ="First Name">
							
								 <input type="text" class="form-control"
							id="lastName" name="lastName" placeholder ="Last Name">

					</div>
					<div class="mb-3">
						<label for="contactDetail" class="form-label">Contact Details</label>
						 <input type="email" class="form-control mb-2"
							id="email" name="email" placeholder ="Email Address">
							
								 <input type="tel" class="form-control"
							id="phoneNumber" name="phoneNumber" placeholder ="Phone Number">
					</div>
					
					<div class="mb-3">
						<label for="petType" class="form-label">Pet Type</label>
						<select class="form-select" id="petType" name="petType">
						  <option selected>Choose your pet type...</option>
						  <option value="1">Dog</option>
						  <option value="2">Cat</option>
						  <option value="3">Bird</option>
						</select>
					</div>
					
						<div class="mb-5">
						<label for="appointmentType" class="form-label">Appointment Type</label>
						<select class="form-select" id="appoinmentType" name="appoinmentType" >
						  <option selected>Choose your appoinment type...</option>
						  <option value="1">Vaccination</option>
						  <option value="2">Consultation - Check up simple issue</option>
						  <option value="3">Consultation - Sick / Injured Pets</option>
							<option value="4">New Pet Boarding</option>
						</select>
					</div>
					
					
				
					<button type="submit" class="btn btn-primary">Next</button>
			
					
				</form>


			</div>
		</div>
	</div>



	</div>

	<!-- Footer starts -->


	<jsp:include page="layout/footer.jsp" />



	<!-- Footer ends -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
		crossorigin="anonymous"></script>
</body>
</html>