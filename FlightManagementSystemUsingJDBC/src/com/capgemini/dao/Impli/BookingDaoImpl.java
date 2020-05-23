package com.capgemini.dao.Impli;


import com.capgemini.dao.Interface.IBookingDao;
import com.capgemini.entities.Booking;
import com.capgemini.util.MyDBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookingDaoImpl implements IBookingDao {
    Connection con = MyDBConnection.getConnection();
    // private List<Booking> bookingList;

    @Override
    public Booking addBooking(Booking b)
    /**
     * Here We add the booking details
     */
    {
        try {
            PreparedStatement ps = con.prepareStatement("insert into Booking values(?,?,?,?)");
            ps.setInt(1, b.getBookingId());
            ps.setString(2, b.getDate());
            ps.setDouble(3, b.getTicketCost());
            ps.setInt(4, b.getNoOfPassengers());
            ps.executeUpdate();
            return b;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Booking modifyBooking(Booking b)
    /**
     * Here we modify the booking details
     */
    {
        try {
            PreparedStatement ps = con.prepareStatement("update Booking set date1=?,noOfPassenger=?,ticketCost=? where bookingId=?");
            ps.setString(1, b.getDate());
            ps.setInt(2, b.getNoOfPassengers());
            ps.setDouble(3,b.getTicketCost());
            ps.setInt(4, b.getBookingId());
            ps.executeQuery();
            return b;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Booking viewBooking(int i)
    /**
     * Here We show the details of booking by specific booking id
     */
    {
        Booking b1 = null;
        // List<Booking> lists = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("Select * from Booking where bookingid =?");
            ps.setInt(1, i);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                b1 = new Booking();
                b1.setBookingId(rs.getInt(1));
                b1.setDate(rs.getString(2));
                b1.setTicketCost(rs.getDouble(3));
                b1.setNoOfPassengers(rs.getInt(4));
            }
            return b1;
            //  return lists;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Booking> viewAllBooking()
    /**
     * Here we show all Booking
     */
    {
        Booking b2 = null;
        List<Booking> lists = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select * from Student");
            while (rs.next()) {
                b2 = new Booking();
                b2.setBookingId(rs.getInt(1));
                b2.setDate(rs.getString(2));
                b2.setTicketCost(rs.getDouble(3));
                b2.setNoOfPassengers(rs.getInt(4));
                lists.add(b2);
            }
            return lists;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void deleteBooking(int i)
    /**
     * Here we delete Booking by booking id
     */
    {
        try {
            PreparedStatement ps = con.prepareStatement("delete from booking where bookingid=?");
            ps.setInt(1, i);
            ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
