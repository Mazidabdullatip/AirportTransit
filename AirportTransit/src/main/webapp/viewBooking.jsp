<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>View Booking</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="colorlib.com">

<!-- MATERIAL DESIGN ICONIC FONT -->
<link rel="stylesheet"
	href="fonts/material-design-iconic-font/css/material-design-iconic-font.css">

<!-- STYLE CSS -->
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<!-- SECTION 1 -->
	<section>
		<div class="inner">
			<div>
				<img src="images/home.png" alt="" width="600" height="800">
			</div>
			<div class="form-content">
				<div class="form-header">
					<h3>Guest Booking</h3>
				</div>
				<div class="form-row">
						<div class="form-holder">
							<a href="BookingController?action=list" class="button">Booking List</a>
						</div>
					</div>
					<p>Booking Info</p>
					<div class="form-row">
						<div class="form-holder">
							Booking Id: <c:out value="${booking.bookingId}" />
						</div>
						<div class="form-holder">
							Customer Email: <c:out value="${booking.email}" />
						</div>
					</div>
					<div class="form-row">
						<div class="form-holder">
							Booking Date: <c:out value="${booking.bookingDate}" />
						</div>
					</div>
					<div class="form-row">
						<div class="form-holder">
							Capsule Price (RM): <c:out value="${booking.room}" />
						</div>
						<div class="form-holder">
							
						</div>
					</div>
					<p>Additional Services</p>
					<div class="form-row">
						<div class="form-holder">
							Shower Price (RM): <c:out value="${booking.shower}" />
						</div>
						<div class="form-holder">
							Locker Rental: <c:out value="${booking.lockerRental}" /> Hours
						</div>
					</div>
					<div class="form-row">
						<div class="form-holder">
							
						</div>
					</div>
					<div class="form-row">
						<div class="form-holder">
						</div>
					</div>
					<div class="form-row">
						<div class="form-holder">
							Total (RM): <c:out value="${booking.total}" />
						</div>
					</div>
			</div>
		</div>
	</section>
	<!-- Template created and distributed by Colorlib -->
</body>
</html>