<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="org.apache.commons.lang3.StringUtils" %>
	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="UTF-8">
		<title>PetCare Vet Clinic</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
			integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
	</head>

	<body>

		<!-- Header starts -->
		<jsp:include page="layout/header.jsp" />
		<!-- Header ends -->
		
		<div class="container">
			<div id="customer-details-form" class="container border border-dark border-1 p-3 m-3 position-relative">
				<div class="row">
					<form action="BookingDetailServlet" method="POST" id="mainForm" >
					<%-- <input type="hidden" value="${displayWeek}" id="displayWeek" name="displayWeek"></input> --%>
						<div class="mb-3">
							<label for="petType" class="form-label">Pet Type</label>
							<select class="form-select" id="petType" name="petType">
								<c:choose>
									<c:when test="${petType == null}">
										<option value="" disabled selected>Choose your pet type...</option>
									</c:when>
									<c:otherwise>
										<option value="" disabled>Choose your pet type...</option>
									</c:otherwise>
								</c:choose>
								<c:forEach items="${petTypeList}" var="each">
									<c:choose>
										<c:when test="${each == petType}">
											<option value="${each}" selected>${StringUtils.capitalize(each)}</option>
										</c:when>
										<c:otherwise>
											<option value="${each}">${StringUtils.capitalize(each)}</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</select>
						</div>
						<div class="mb-5">
							<label for="appointmentType" class="form-label">Appointment Type</label>
							<select class="form-select" id="appointmentType" name="appointmentType">
								<c:choose>
									<c:when test="${appointmentType == null}">
										<option value="" disabled selected>Choose your pet type...</option>
									</c:when>
									<c:otherwise>
										<option value="" disabled>Choose your pet type...</option>
									</c:otherwise>
								</c:choose>
								<c:forEach items="${appointmentTypeList}" var="each">
									<c:choose>
										<c:when test="${each == appointmentType}">
											<option value="${each}" selected>${StringUtils.capitalize(each)}</option>
										</c:when>
										<c:otherwise>
											<option value="${each}">${StringUtils.capitalize(each)}</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</select>
						</div>		
						<div>
								<button type="submit" class="btn btn-primary">Next</button>
						</div>										
		<%-- 				<table id="timetable" class="table" style="display:none">
							<tr>
								<td colspan="4">
								  <button class="btn btn-primary" type="button" id="btnPrevWeek">Previous Week</button>
								</td>
								<td colspan="4" class="text-end">
								  <button class="btn btn-primary" type="button" id="btnNextWeek">Next Week</button>
								</td>
							</tr>
							<tr>
								<th colspan="8" class="text-center">Available Time</th>
							</tr>
							<tr>
								<th colspan="8" class="text-center"><c:out value="${datesOfWeek[0]} - ${datesOfWeek[6]}" /></th>
							</tr>
							<tr>
								<th scope="col">Time/Date</th>
								<th scope="col">Monday <br/><c:out value="${datesOfWeek[0]}" /></th>
								<th scope="col">Tuesday <br/><c:out value="${datesOfWeek[1]}" /></th>
								<th scope="col">Wednesday <br/><c:out value="${datesOfWeek[2]}" /></th>
								<th scope="col">Thursday <br/><c:out value="${datesOfWeek[3]}" /></th>
								<th scope="col">Friday <br/><c:out value="${datesOfWeek[4]}" /></th>
								<th scope="col">Saturday <br/><c:out value="${datesOfWeek[5]}" /></th>
								<th scope="col">Sunday <br/><c:out value="${datesOfWeek[6]}" /></th>
							</tr>
							<c:set var="today" value="${LocalDate.now()}"/>
							<c:forEach var="i" begin="1" end="16">
								<tr>
									<c:forEach var="j" begin="1" end="8">
										<c:choose>
											<c:when test="${j==1}">
												<td><c:out value="${timeslotsTemplate[i-1]}" /></td>
											</c:when>
											<c:otherwise>
												<td><c:out value="${today.isAfter(datesOfWeek[j-2])?\"Unavailable\":\"Available\"}"/></td>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</tr>
							</c:forEach>
						</table> --%>
					</form>
				</div>
			</div>
		</div>

		<!-- Footer starts -->
		<jsp:include page="layout/footer.jsp" />
		<!-- Footer ends -->

		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
			crossorigin="anonymous"></script>
<!-- 		<script> -->
//         if (document.querySelector("#petType").value != '' && document.querySelector("#appointmentType").value != '') {
//             document.querySelector("#timetable").style.display = '';
//         } else {
//             document.querySelector("#timetable").style.display = 'none';
//         } 
		
// 			document.querySelector("#petType").addEventListener("change", function(e) {
// 				if (document.querySelector("#petType").value != '' && document.querySelector("#appointmentType").value != '') {
// 					document.querySelector("#timetable").style.display = '';
// 				} else {
// 					document.querySelector("#timetable").style.display = 'none';
// 				}			
// 			});
			
// 			document.querySelector("#appointmentType").addEventListener("change", function(e) {
// 				if (document.querySelector("#petType").value != '' && document.querySelector("#appointmentType").value != '') {
// 					document.querySelector("#timetable").style.display = '';
// 				} else {
// 					document.querySelector("#timetable").style.display = 'none';
// 				}
// 			});
			
// 			document.querySelector("#btnNextWeek").addEventListener("click", function(e) {
// 				var displayWeek = parseInt(document.querySelector("#displayWeek").value);
// 				document.querySelector("#displayWeek").value = displayWeek + 1;
// 				document.querySelector("#mainForm").submit();
// 			});
			

<!-- 		</script> -->
	</body>

	</html>