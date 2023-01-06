<%@page import="util.DummyMedicalService"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PetCare Vet Clinic</title>
<link href="public/css/home.css" rel="stylesheet" type="text/css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
	
<c:set var = "services" value = '<%= Arrays.asList(
		new DummyMedicalService(1,"BOARDING", "boarding description", "public/images/boarding.png", 10.10),
		new DummyMedicalService(2,"DESEXING" ,"desexing description", "public/images/desexing.png", 10.10),
		new DummyMedicalService(3,"CONSULTATION" ,"consultations description", "public/images/consultation.png", 10.10),
		new DummyMedicalService(4,"DENTISTRY" ,"dentistry description", "public/images/dentistry.png", 10.10),
		new DummyMedicalService(5,"MICROCHIPING" ,"microchiping description", "public/images/microchip.png", 10.10),
		new DummyMedicalService(6,"WORMING" ,"worming description", "public/images/worming.png", 10.10),
		new DummyMedicalService(7,"SURGERY" ,"surgery description", "public/images/surgery.png", 10.10),
		new DummyMedicalService(8,"IMAGING" ,"imaging description", "public/images/imaging.png", 10.10)
		) %>'></c:set>
		
</head>
<body>
	<!-- Header starts -->
	<jsp:include page="layout/header.jsp" />
	<!-- Header ends -->

	<div class="d-flex flex-column  align-items-center">
		<div class="">Banner</div>
		<hr>
		<h1>OUR SERVICES</h1>
		<div class="container d-flex flex-wrap justify-content-center gap-3 p-5">
		
	
			<c:forEach var="service" items="${services}">
				<div class="card" style="width: 18rem;">
				<img src="${service.imageUrl} " class="card-img-top w-25 " alt="...">
				<div class="card-body">
					<h5 class="card-title">${service.name}</h5>
					<p class="card-text">${service.description}</p>
					<a href="#" class="card-link">Learn More ...</a>
				</div>
			</div>
			</c:forEach>

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