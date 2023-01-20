
<%@page import="entity.MedicalService"%>
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
</head>
<body>
	<!-- Header starts -->
	<jsp:include page="layout/header.jsp" />
	<!-- Header ends -->

	<div class="d-flex flex-column  align-items-center">
		<div class="">Banner</div>
		<hr>
		<h1>OUR SERVICES</h1>
			<!-- common service -->
			<jsp:include page="components/common.service.jsp" />
			
			<!-- ends -->
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