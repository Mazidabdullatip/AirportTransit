package transit.model;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Author: FES
 * Date: 21 June 2023
 * Purpose: CSC584 Assignment 2
 * Student name:MAZIDATUL IZZAH BINTI ABDUL LATIP
 * Student id:2021486314
 */

public class Booking {
  int bookingId;
  Date bookingDate;
  String room;
  double shower;
  int lockerRental;
  double total;
  String varchar;
  
  public Booking(int bookingId, Date bookingDate, String room, double shower, int lockerRental, double total,
      String varchar) {
    super();
    this.bookingId = bookingId;
    this.bookingDate = bookingDate;
    this.room = room;
    this.shower = shower;
    this.lockerRental = lockerRental;
    this.total = total;
    this.varchar = varchar;
  }

  public int getBookingId() {
    return bookingId;
  }

  public void setBookingId(int bookingId) {
    this.bookingId = bookingId;
  }

  public Date getBookingDate() {
    return bookingDate;
  }

  public void setBookingDate(Timestamp bookingDate) {
    this.bookingDate = bookingDate;
  }

  public String getRoom() {
    return room;
  }

  public void setRoom(String room) {
    this.room = room;
  }

  public double getShower() {
    return shower;
  }

  public void setShower(double shower) {
    this.shower = shower;
  }

  public int getLockerRental() {
    return lockerRental;
  }

  public void setLockerRental(int lockerRental) {
    this.lockerRental = lockerRental;
  }

  public double getTotal() {
    return total;
  }

  public void setTotal(double total) {
    this.total = total;
  }

  public String getVarchar() {
    return varchar;
  }

  public void setVarchar(String varchar) {
    this.varchar = varchar;
  }

  public String getEmail() {
    // TODO Auto-generated method stub
    return null;
  }

  public void setBookingDate(Date date) {
    // TODO Auto-generated method stub
    
  }

  public void setEmail(String email) {
    // TODO Auto-generated method stub
    
  }

  
  
  
  
  
}