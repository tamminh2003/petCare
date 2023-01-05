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

		<div class="container border border-dark border-1 p-3 m-3">
			<div class="row">
				<div class="col">Dr Alex Johnson</div>
				<div class="col-9">
					<table class="table table-dark table-striped-columns">
						<thead>
							<tr>
								<th >Mon</th>
								<th >Tue</th>
								<th >Weds</th>
								<th >Thurs</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>9:00 - 9:15</td>
								<td>10:00 - 10:15 -</td>
								<td>11:00 - 11:15</td>
								<td>11:15 - 11:30</td>
							</tr>
							<tr>
								<td>9:00 - 9:15</td>
								<td>10:00 - 10:15 -</td>
								<td>11:00 - 11:15</td>
								<td>11:15 - 11:30</td>
							</tr>
							<tr>
								<td>9:00 - 9:15</td>
								<td>10:00 - 10:15 -</td>
								<td>11:00 - 11:15</td>
								<td>11:15 - 11:30</td>
							</tr>
						</tbody>

					</table>
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