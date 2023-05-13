<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.time.LocalDate" %>	
<%@ page import="java.time.format.TextStyle" %>	
<%@ page import="java.util.Locale" %>	

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PetCare Vet Clinic</title>
<link href="public/css/bookingDetail.css" rel="stylesheet" type="text/css">
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

		<div class="container border border-dark border-1 p-3 m-3">
		<form method="GET" action="BookingConfirmServlet" id="mainForm">
		<input type="hidden" value="" id="timeslot" name="timeslot"/>
		<input type="hidden" value="" id="vetId" name="vetId"/>
			<c:forEach var = "vetTimeslot" items = "${vetTimeslotList}">		
				<div class="row">
				<div class="col">${vetTimeslot.vetName}</div>
				<div class="col-9">
					<div class="row">
					
						<c:forEach var="date" items="${vetTimeslot.timeslots.keySet()}">
					    <div>${date.getDayOfWeek().toString()}</div>
					    <div>${date.toString()}</div>
					    <div class="col">
			        
			        	<c:forEach var="time" items="${vetTimeslot.timeslots.get(date)}">	
			        		<div class="time-button" data-time="${date.toString().concat(" ").concat(time.toString())}" data-vetid="${vetTimeslot.getVetId()}">${time}</div>
			        	</c:forEach>
			        	
					    </div>
						</c:forEach>
						
					</div>
				</div>
			</div>
			<hr />
			</c:forEach>
			
			<div class="d-flex flex-row justify-content-between m-5">
				<div>
				 <button type="button" id="back-button" class="btn btn-primary">Back</button>
				</div>
				<div>
				 <button type="button" id="next-button" class="btn btn-primary">Next</button>	
				</div>			 
			</div>	
			
		</form>		
		</div>



	</div>

	<!-- Footer starts -->


	<jsp:include page="layout/footer.jsp" />



	<!-- Footer ends -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
		crossorigin="anonymous"></script>
			
	<script>
	document.querySelectorAll(".time-button").forEach(element => {
		  element.addEventListener("click", (event) => {
			  
			  document.querySelectorAll(".time-button").forEach(element => {
				  element.classList.remove("selected");
			  });
			  
			  event.target.classList.add("selected");
		  });
		});
		  
		var nextButton = document.getElementById("next-button");
		console.log(nextButton);

		function nextButtonHandler (event) {
		  document.querySelectorAll(".time-button").forEach(element => {
		      if (element.classList.contains("selected")) {
		    	  document.querySelector("#timeslot").value = element.dataset.time;
		    	  document.querySelector("#vetId").value = element.dataset.vetid;
		      }
		  });
		  document.querySelector("#mainForm").submit();
		};	
		  
		nextButton.addEventListener("click", nextButtonHandler);
		  
    document.getElementById("back-button").onclick = function () {
        location.href = `BookingServlet?time=${time}`;
    }
	</script>


</body>
</html>