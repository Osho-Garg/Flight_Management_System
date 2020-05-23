package com.capgemini.entities;

import java.sql.Date;
import java.util.List;


public class Booking
/**
 * Class booking
 */
{
    private int bookingId;
    private int userId;
    private String date;
    private List<Passenger> passengerList;
    private double ticketCost;
    private Flight flight;
    private int noOfPassengers;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Booking()
    /**
     * Unparameterized Constructor of booking
     */
    {

    }

    public Booking(int bookingId, String date, double ticketCost, int noOfPassengers)
    /**
     * parameterized Constructor of Booking
     */
    {


        this.bookingId = bookingId;
       // this.userId = userId;
        this.date = date;
        //this.passengerList = passengerList;
        this.ticketCost = ticketCost;
       // this.flight = flight;
        this.noOfPassengers = noOfPassengers;
    }



    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getuserId() {
        return userId;
    }

    public void setuserId(int userId) {
        this.userId = userId;
    }

   /* public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Passenger> getPassengerList() {
        return passengerList;
    }

    public void setPassengerList(List<Passenger> passengerList) {
        this.passengerList = passengerList;
    }*/

    public double getTicketCost() {
        return ticketCost;
    }

    public void setTicketCost(double ticketCost) {
        this.ticketCost = ticketCost;
    }

   /* public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }*/

    public int getNoOfPassengers() {
        return noOfPassengers;
    }

    public void setNoOfPassengers(int noOfPassengers) {
        this.noOfPassengers = noOfPassengers;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", date='" + date + '\'' +
                ", ticketCost=" + ticketCost +
                ", noOfPassengers=" + noOfPassengers +
                '}';
    }

    public void setBookingDate(Date bookingDate1) {
    }
}
