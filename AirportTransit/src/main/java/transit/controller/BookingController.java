package transit.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import transit.dao.BookingDAO;
import transit.model.Booking;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Servlet implementation class BookingController
 * Author: FES
 * Date: 21 June 2023
 * Purpose: CSC584 Assignment 2
 * Student name:MAZIDATUL IZZAH BINTI ABDUL LATIP
 * Student id:2021486314
 */

@WebServlet("/Booking")
public class BookingController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private String action = "", forward = "";
    private static String LIST = "listBooking.jsp";
    private static String VIEW = "viewBooking.jsp";
    private BookingDAO dao;
    private int bookingId;
    private double total = 0.00;
  int locker = (int) 0.00;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingController() {
        super();
        dao = new BookingDAO();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action = request.getParameter("action");

        if (action.equalsIgnoreCase("view")) {
            forward = VIEW;
            // get bookingId from the request
            bookingId = Integer.parseInt(request.getParameter("bookingId"));

            // set attribute to a servlet request and call getBooking() in BookingDAO
            request.setAttribute("booking", BookingDAO.getCustomerBooking(bookingId));
        }

        if (action.equalsIgnoreCase("list")) {
            forward = LIST;
            // set attribute to a servlet request and call getAllBookings() in BookingDAO
            List<Booking> bookings = BookingDAO.getCustomerBookings();
            request.setAttribute("bookings", bookings);
        }

        if (action.equalsIgnoreCase("delete")) {
            forward = LIST;
            // get bookingId from the request
            bookingId = Integer.parseInt(request.getParameter("bookingId"));

            // invoke deleteBooking() method in BookingDAO
            dao.deleteBooking(bookingId);

            // set attribute to a servlet request and call getAllBookings() in BookingDAO
            List<Booking> bookings = BookingDAO.getCustomerBookings();
            request.setAttribute("bookings", bookings);
        }

        // forward the request
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Booking booking = new Booking(bookingId, null, null, 0, 0, 0, null); // create object

        // retrieve values from HTML form and set them
        booking.setBookingDate(new Date());
        booking.setRoom(request.getParameter("room"));
        booking.setShower(Double.parseDouble(request.getParameter("shower")));
        booking.setLockerRental(Integer.parseInt(request.getParameter("lockerRental")));
        booking.setEmail(request.getParameter("email"));

        // calculate locker rental
        locker = (int) (booking.getLockerRental() * 10.00);
        booking.setLockerRental(locker);

        // calculate total
        total = 0.00;
        String roomType = booking.getRoom();
        if (roomType.equalsIgnoreCase("single")) {
            total += 120.00;
        } else if (roomType.equalsIgnoreCase("queen")) {
            total += 180.00;
        } else if (roomType.equalsIgnoreCase("private")) {
            total += 200.00;
        }
        total += booking.getShower() * 25.00;
        total += locker;
        booking.setTotal(total);
        
     // invoke addBooking() method in BookingDAO
        dao.addBooking(booking);

        // set attribute to a servlet request and call getAllBookings() in BookingDAO
        List<Booking> bookings = BookingDAO.getCustomerBookings();
        request.setAttribute("bookings", bookings);

        forward = LIST;
        // forward the request to listBooking.jsp
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
}

        