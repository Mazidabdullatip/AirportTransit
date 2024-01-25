<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
		<meta charset="utf-8">
		<title>New Booking</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="author" content="colorlib.com">

		<!-- MATERIAL DESIGN ICONIC FONT -->
		<link rel="stylesheet" href="fonts/material-design-iconic-font/css/material-design-iconic-font.css">

		<!-- STYLE CSS -->
		<link rel="stylesheet" href="css/style.css">
	</head>
	<body>
            <form action="BookingController" method="post" id="wizard">
        		<!-- SECTION 1 -->
                <h2></h2>
                <section>
                    <div class="inner">
						<div>
							<img src="images/home.png" alt="" width="600" height="800">
						</div>
						<div class="form-content" >
							<div class="form-header">
								<h3>New Booking</h3>
						</div>
					<p>Customer Details</p>
							<div class="form-row">
								<div class="form-holder">
									<input type="email" name="email" placeholder="Email" class="form-control">
								</div>
							</div>
							<p>Capsule Type</p>
							<p class="text"><b>Single capsule:</b> RM120 (per entry) |
							<b>Queen capsule:</b> RM180 (per entry)|
							<b>Private capsule:</b> RM200 (per entry)
							</p>
							<div class="form-row">
								<div class="form-holder">
									<select name="room" class="form-control">
											<option value="120.00">Single</option>
											<option value="180.00">Queen</option>
											<option value="200.00">Private</option>
									</select>
								</div>
								<div class="form-holder">
								</div>		
						</div>
						<p>Shower</p>
						<p class="text">Shower only packages (warm water) are available (per entry) for RM 25 which includes towel, shampoo, shower gel, hair dryer and slippers</p>
							<div class="form-row">
								<div>
									<input type="radio" name="shower" value="25.00">Yes
									<input type="radio" name="shower" value="0.00">No
							</div>			
						</div>
						<p>Locker Rental</p>
						<p class="text">RM10 per hour (Maximum size 30inch luggage)</p>
							<div class="form-row">
								<div class="form-holder">
									<input type="number" name="lockerRental" placeholder="Locker Rental Hours (0-12 hours)" min="0" max="12" class="form-control">
							</div>			
						</div>
						<div class="form-row">
								<div class="form-holder">
									<input type="submit" value="Book Now" class="button">
									<input type="reset" value="Reset" class="button">	
								</div>		
						</div>
					</div>
					</div>
                </section>
 			</form>
		<!-- Template created and distributed by Colorlib -->
</body>
</html>