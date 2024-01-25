<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
		<meta charset="utf-8">
		<title>Booking List</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="author" content="colorlib.com">

		<!-- MATERIAL DESIGN ICONIC FONT -->
		<link rel="stylesheet" href="fonts/material-design-iconic-font/css/material-design-iconic-font.css">

		<!-- STYLE CSS -->
		<link rel="stylesheet" href="css/style.css">
	</head>
	<body>
    <!-- SECTION 1 -->
    <h2></h2>
	<section>
		<div class="inner">
			<div>
				<img src="images/home.png" alt="" width="600" height="800">
			</div>
			<div class="form-content">
				<div class="form-header">
					<h3>Booking List</h3>
				</div>
					<div class="form-row">
						<div class="form-holder">
							<a href="booking.jsp" class="button">Book Now</a>
						</div>
					</div>
						<table style="width:100%;text-align:left;">
							<tr>
								<th>Booking Id</th>
								<th>Booking Date</th>
								<th>Email</th>
								<th>Total</th>
								<th colspan="3"></th>
							</tr>
							<c:forEach items="${bookings}" var="booking">
								<tr>
									<td><c:out value="${booking.bookingId}" /></td>
									<td><c:out value="${booking.bookingDate}" /></td>
									<td><c:out value="${booking.email}" /></td>
									<td><c:out value="${booking.total}" /></td>
									<td><a href="BookingController?action=view&bookingId=<c:out value="${booking.bookingId}"/>" class="button">View</a>
									<a href="BookingController?action=delete&bookingId=<c:out value="${booking.bookingId}" />" class="button">Delete</a></td>
							</c:forEach>
						</table>
			</div>
		</div>
	</section>
	<!-- Template created and distributed by Colorlib -->
</body>
</html>