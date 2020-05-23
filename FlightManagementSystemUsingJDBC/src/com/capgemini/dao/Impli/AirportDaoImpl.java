package com.capgemini.dao.Impli;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.capgemini.dao.Interface.IAirportDao;
import com.capgemini.entities.*;
import com.capgemini.util.MyDBConnection;


public class AirportDaoImpl implements IAirportDao
/**
 * Here We enter the Airport the details in DataBase
 */
{
	 Connection con = MyDBConnection.getConnection();
	@Override
	public List<Airport> viewAllAirport()
	/**
	 * Here We Show List of Airport
	 */
	{
	Airport a=null;
	
      List<Airport> lists = new ArrayList<>();
      try {
    	  Statement st = con.createStatement();
          ResultSet rs = st.executeQuery("Select * from Airport");

          while (rs.next()) {
             a = new Airport();
             a.setAirportCode(rs.getString(1));
             a.setAirportName(rs.getString(2));
             a.setAirportLocation(rs.getString(3));
              lists.add(a);
          }
          return lists;
      } catch (SQLException e) {
          e.printStackTrace();
          return null;
      }
	}

	@Override
	public Airport viewAirport(String airportCode)
	/**
	 * Here we show the Detail of the specific Airport
	 */
	{

	        try {
	            PreparedStatement ps = con.prepareStatement("Select * from Airport where airportCode =?");
	            ps.setString(1, airportCode);
	            ResultSet rs = ps.executeQuery();
	          if (rs.next()) {
	            	Airport a = new Airport();
	                 a.setAirportCode(rs.getString(1));
	                 a.setAirportName(rs.getString(2));
	                 a.setAirportLocation(rs.getString(3));
	               return a;
	            }
	          else
	          {
	        	  return null ;
	          }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }
	}
}
