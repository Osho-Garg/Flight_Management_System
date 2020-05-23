package com.capgemini.dao.Impli;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.capgemini.dao.Interface.IFlightDao;
import com.capgemini.entities.Flight;


import com.capgemini.util.MyDBConnection;
public class FlightDaoImpl implements IFlightDao {
	 Connection con = MyDBConnection.getConnection();
	@Override
	public Flight addFlight(Flight f)
	/**
	 * here we ad new Flight details
	 */
	{
		try {
	            PreparedStatement ps = con.prepareStatement("insert into Flight values(?,?,?,?)");
	            ps.setInt(1,f.getFlightNumber());
	            ps.setString(2,f.getFlightModel());
	            ps.setInt(3,f.getSeatCapacity());
	            ps.setString(4,f.getCarrierName());
	            ps.executeQuery();
	            System.out.println("Flight created");
	            return f;
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }
		
	}

	@Override
	public Flight modifyFlight(Flight f)
	/**
	 * Here we modify flight details by flight id
	 */
	{

		
		  try {
	            PreparedStatement ps = con.prepareStatement("update  Flight set flightModel=?, seatCapacity=? , carrierName=? where flightNumber=?");
	            ps.setString(1,f.getFlightModel());
	            ps.setInt(2,f.getSeatCapacity());
	            ps.setString(3,f.getCarrierName());
	            ps.setInt(4,f.getFlightNumber());
	            ps.executeQuery();
	            return f;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }

		
	}

	@Override
	public Flight viewFlight(int flightNumber)
	/**
	 * here we show details of Flight by flight id
	 */
	{
		 Flight f = null;
	       // List<Flight> lists = new ArrayList<>();
	        try {
	            PreparedStatement ps = con.prepareStatement("Select * from Flight where FlightNumber =?");
	            ps.setInt(1, flightNumber);
	            ResultSet rs = ps.executeQuery();
	          if (rs.next()) {
	            	 f = new Flight();
	                 f.setFlightNumber(rs.getInt(1));
	                 f.setFlightModel(rs.getString(2));
	                 f.setSeatCapacity(rs.getInt(3));
	                 f.setCarrierName(rs.getString(4));
	               return f;
	            }
	          else
	          {
	        	  return null;
	          }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }
	}

	@Override
	public List<Flight> viewAllFlight()
	/**
	 * Here we show list of all flights
	 */
	{
		Flight f=null;
		
	      List<Flight> lists = new ArrayList<>();
	      try {
	    	  Statement st = con.createStatement();
	          ResultSet rs = st.executeQuery("Select * from Flight");
	          while (rs.next()) {
	             f = new Flight();
	             f.setFlightNumber(rs.getInt(1));
                 f.setFlightModel(rs.getString(2));
                 f.setSeatCapacity(rs.getInt(3));
                 f.setCarrierName(rs.getString(4));
	              lists.add(f);
	          }
	          return lists;
	      } catch (SQLException e) {
	          e.printStackTrace();
	          return null;
	      }
	}

	@Override
	public void deleteFlight(int flightNumber)
	/**
	 * here we delete the flight by the flightNUmber
	 */
	{
		// TODO Auto-generated method stub
		
		  try{
	            PreparedStatement ps=con.prepareStatement("delete from Flight where flightNumber=?");
	            ps.setInt(1, flightNumber);
	            ps.executeQuery();
	            System.out.println("Flight is Deleted");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	    }
		
	}


