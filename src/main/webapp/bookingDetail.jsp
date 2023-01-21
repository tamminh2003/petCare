<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
			<div class="row">
	
				<div class="col">Dr Alex Johnson</div>
				
				<div class="col-9">
			
					<div class="row">
						<div class="col">
							<div class="date" data-time="0900">
								<div>Sat</div>
								<div>Jan 21</div>
							</div>
							<div class="time-button" data-time="0900">9:00 AM</div>
							<div class="time-button" data-time="0930">9:30 AM</div>
							<div class="time-button" data-time="1000">10:00 AM</div>
							<div class="time-button" data-time="1030">10:30 AM</div>
						
						</div>	
	
						<div class="col">test</div>		
						<div class="col">test</div>		
						<div class="col">test</div>	
						<div class="col">test</div>				
					</div>
					
					
				</div>
			</div>
			
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