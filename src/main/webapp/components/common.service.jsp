
<%@page import="main.java.entity.MedicalService"%>
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
<title>Common Services</title>
<link href="public/css/home.css" rel="stylesheet" type="text/css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">

<%-- <c:set var = "services" value = '<%= Arrays.asList(
		new MedicalService(1,"BOARDING", "boarding description", "public/images/boarding.png"),
		new MedicalService(2,"DESEXING" ,"desexing description", "public/images/desexing.png"),
		new MedicalService(3,"CONSULTATION" ,"consultations description", "public/images/consultation.png"),
		new MedicalService(4,"DENTISTRY" ,"dentistry description", "public/images/dentistry.png"),
		new MedicalService(5,"MICROCHIPING" ,"microchiping description", "public/images/microchip.png"),
		new MedicalService(6,"WORMING" ,"worming description", "public/images/worming.png"),
		new MedicalService(7,"SURGERY" ,"surgery description", "public/images/surgery.png"),
		new MedicalService(8,"IMAGING" ,"imaging description", "public/images/imaging.png")
		) %>'></c:set> --%>

</head>
<body>
<div class="container d-flex flex-wrap justify-content-center gap-3 p-5">

	<c:forEach var="service" items="${services}">
		<div class="card" style="width: 18rem;">
			<img src="${service.imageURL} " class="card-img-top w-25 " alt="...">
			<div class="card-body">
				<h5 class="card-title">${service.name}</h5>
				<p class="card-text">${service.description}</p>
				<a href="http://localhost:8080/pet-care/serviceDetail.jsp?name=${service.name}&description=${service.description}&imageUrl=${service.imageURL}" class="card-link">Learn More ...</a>
			</div> 
		</div>
	</c:forEach>

</div>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
	crossorigin="anonymous"></script>
</body>
</html>