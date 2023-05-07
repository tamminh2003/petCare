<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page 
	import="java.time.*" %>	
<%@ page 
	import="java.time.format.TextStyle" %>	
	<%@ page 
		import="java.util.Locale" %>	

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
		<form>
			<c:forEach var = "vetTimeslot" items = "${vetTimeslotList}">
			
				
				<div class="row">
	
				<div class="col">${vetTimeslot.vetName}</div>
				
				<div class="col-9">
			
					<div class="row">
						<c:forEach var="date" items="${vetTimeslot.timeslots.keySet()}">
						    <c:set var="dateObject" value="${java.time.LocalDate.parse(date)}"/>
						    <c:set var="debug" value="testing"/>
						    <c:set var="dayOfWeekObject" value="${dateObject.getDayOfWeek()}"/>
						    <c:set var="dayOfWeekString" value="${dayOfWeekObject.getDisplayName(TextStyle.FULL, Locale.getDefault())}"/>
					
						    <div class="col">
						        <div class="date" data-time="0900">
						        	  <%-- TRY TO LOG OUT DATEOBJECT TO DEBUG BUT IT IS EMPTY --%>
						            <div>${dateObject}</div> 
						            <div>${date}</div>
						        </div>
						        	<c:forEach var="time" items="${vetTimeslot.timeslots.get(date)}">	
						        		<div class="time-button" data-time="0930">${time}</div>
						        	</c:forEach>
						    </div>
						</c:forEach>
					</div>
				</div>
			</div>
			</c:forEach>
			<div class="d-flex flex-row justify-content-between m-5">
				<div>
				 <button type="button" id="back-button">Back</button>
				</div>
				<div>
				 <button type="button" id="next-button">Next</button>	
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
			  
		/* 	  
		    if(event.target.classList.contains("selected")) {
		      event.target.classList.remove("selected");
		    } else {
		      
		    } */
		  });
		});
		  
		var nextButton = document.getElementById("next-button");

		function nextButtonHandler (event) {
		  
		  var time = '';
		  document.querySelectorAll(".time-button").forEach(element => {
		      if (element.classList.contains("selected")) {
		        time = element.dataset.time; 
		      }
		    });
		  
		  var formData = new FormData();
		  formData.append("time", time);
			console.log(formData);
		  
/* 	 const request = new XMLHttpRequest();
		  request.open("POST", "BookingConfirmServlet");
		  request.send(formData); */
		    location.href = "BookingConfirmServlet"; 
		};	
		  
		nextButton.addEventListener("click", nextButtonHandler);
		  
	    document.getElementById("back-button").onclick = function () {
	    	console.log("back clicked")
	        location.href = `BookingServlet?time=${time}`;
	    }
	    
	
	</script>


</body>
</html>