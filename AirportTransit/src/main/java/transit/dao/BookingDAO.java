package transit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import transit.connection.ConnectionManager;
import transit.model.Booking;

public class BookingDAO {
    private static Connection con = null;
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;

    // Get a customer booking by booking ID
    public static Booking getCustomerBooking(int bookingId) {
        Booking booking = null;

        try {
            // Get connection
            con = ConnectionManager.getConnection();

            // Create SQL query
            String query = "SELECT * FROM booking WHERE bookingId = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, bookingId);

            // Execute query
            rs = ps.executeQuery();

            // Retrieve booking details
            if (rs.next()) {
                int id = rs.getInt("bookingId");
                Date bookingDate = rs.getTimestamp("bookingDate");
                String room = rs.getString("room");
                double shower = rs.getDouble("shower");
                int lockerRental = rs.getInt("lockerRental");
                double total = rs.getDouble("total");
                String email = rs.getString("email");

                booking = new Booking(id, bookingDate, room, shower, lockerRental, total, email);
            }

            // Close resources
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return booking;
    }

    // Add a booking
    public void addBooking(Booking bean) {
        try {
            // Get connection
            con = ConnectionManager.getConnection();

            // Create SQL query
            String query = "INSERT INTO booking (bookingDate, room, shower, lockerRental, total, email) VALUES (?, ?, ?, ?, ?, ?)";
            ps = con.prepareStatement(query);
            ps.setTimestamp(1, new java.sql.Timestamp(bean.getBookingDate().getTime()));
            ps.setString(2, bean.getRoom());
            ps.setDouble(3, bean.getShower());
            ps.setInt(4, bean.getLockerRental());
            ps.setDouble(5, bean.getTotal());
            ps.setString(6, bean.getEmail());

            // Execute query
            ps.executeUpdate();

            // Close resources
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Delete a booking by booking ID
    public void deleteBooking(int bookingId) {
        try {
            // Get connection
            con = ConnectionManager.getConnection();

            // Create SQL query
            String query = "DELETE FROM booking WHERE bookingId = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, bookingId);

            // Execute query
            ps.executeUpdate();

            // Close resources
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Get all customer bookings
    public static List<Booking> getCustomerBookings() {
        List<Booking> bookings = new ArrayList<>();

        try {
            // Get connection
            con = ConnectionManager.getConnection();

            // Create SQL query
            String query = "SELECT * FROM booking";
            ps = con.prepareStatement(query);

            // Execute query
            rs = ps.executeQuery();
         // Retrieve booking details
            while (rs.next()) {
                int id = rs.getInt("bookingId");
                Date bookingDate = rs.getTimestamp("bookingDate");
                String room = rs.getString("room");
                double shower = rs.getDouble("shower");
                int lockerRental = rs.getInt("lockerRental");
                double total = rs.getDouble("total");
                String email = rs.getString("email");

                Booking booking = new Booking(id, bookingDate, room, shower, lockerRental, total, email);
                bookings.add(booking);
            }

            // Close resources
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bookings;
    }
}