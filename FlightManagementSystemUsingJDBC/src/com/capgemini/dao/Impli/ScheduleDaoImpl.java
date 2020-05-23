package com.capgemini.dao.Impli;

import com.capgemini.dao.Interface.ScheduleDao;
import com.capgemini.entities.Flight;
import com.capgemini.entities.Schedule;
import com.capgemini.util.MyDBConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ScheduleDaoImpl implements ScheduleDao {
    Connection con = MyDBConnection.getConnection();
    @Override
    public Schedule scheduleFlight(Schedule scheduleFlight)
    /**
     * Here we add the schedule flight
     */
    {

        try {
            PreparedStatement ps = con.prepareStatement("insert into schedule values (?,?,?,?,?,?,?)");
            ps.setString(1, scheduleFlight.getScheduleId());
            ps.setString(2, scheduleFlight.getSourceAirport());
            ps.setString(3, scheduleFlight.getDestinationAirport());
            ps.setString(4, scheduleFlight.getDepartureDate());
            ps.setString(5, scheduleFlight.getDepartureTime());
            ps.setString(6, scheduleFlight.getArrivalDate());
            ps.setString(7, scheduleFlight.getArrivalTime());
            int s = ps.executeUpdate();
            if (s >= 1) {
                return scheduleFlight;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;

    }

    @Override
    public List<Schedule> viewScheduledFlight(String source, String destination, Date ld)
    /**
     * Here we show details of the schedule flight by the specific source and destination and date of flights
     */
    {
        List<Schedule> scheduledFlightList=new ArrayList<>();
        try {
            PreparedStatement pst = con.prepareStatement(
                    "Select * from schedule where source_airport=? and destination_airport=? and departure_date_=?");
            pst.setString(1, source);
            pst.setString(2, destination);
            pst.setDate(3, ld);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Schedule schedule = new Schedule();
                schedule.setScheduleId(rs.getString(1));
                schedule.setSourceAirport(rs.getString(2));
                schedule.setDestinationAirport(rs.getString(3));
                schedule.setDepartureDate(rs.getString(4));
                schedule.setDepartureTime(rs.getString(5));
                schedule.setArrivalDate(rs.getString(6));
                schedule.setArrivalTime(rs.getString(7));
                scheduledFlightList.add(schedule);
            }
            return scheduledFlightList;
        } catch (Exception e) {

        }
        return null;
    }

    @Override
    public Flight viewScheduledFlight(String flightNumber)
    /**
     * Here we show ScheduleFlight details by the schedule id
     */
    {
        try {
            PreparedStatement ps = con.prepareStatement("Select schedule_id from schedule where schedule_id=?");
            ps.setString(1, flightNumber);
            ResultSet rs = ps.executeQuery();

            String sid = null;
            while (rs.next()) {
                sid = rs.getString(1);
            }
            PreparedStatement pst = con.prepareStatement("Select * from Flight where flightnumber=?");
            pst.setString(1, sid);
            ResultSet rss = pst.executeQuery();
            Flight flight = new Flight();
            while (rss.next()) {
                flight.setFlightNumber(rss.getInt(1));
                flight.setCarrierName(rss.getString(4));
                flight.setFlightModel(rss.getString(2));
                flight.setSeatCapacity(rss.getInt(3));
            }
            return flight;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Schedule modifyScheduledFlight(String flightNumber, Schedule schedule)
    /**
     * Here we modify the Schedule Flight by the flightnumber and Schedule id
     */
    {
        try {
            PreparedStatement ps = con.prepareStatement(
                    "Update schedule set source_airport=?,destination_airport=?,departure_date_=?,departure_time_=?,arrival_date_=?,arrival_time_=? where schedule_id=?");
            ps.setString(1, schedule.getSourceAirport());
            ps.setString(2, schedule.getDestinationAirport());
            ps.setString(3, schedule.getDepartureDate());
            ps.setString(4, schedule.getDepartureTime());
            ps.setString(5, schedule.getArrivalDate());
            ps.setString(6, schedule.getArrivalTime());
            ps.setString(7, flightNumber);
            int s = ps.executeUpdate();
            if (s >= 1) {
                return schedule;
            }
        } catch (Exception e) {

        }

        return null;
    }

    @Override
    public void deleteScheduledFlight(String scheduleId)
    /**
     * Here we delete schedule Flight by the Specific Schedule_Id
     */
    {
        try {
            PreparedStatement ps = con.prepareStatement("Delete from schedule where schedule_id=?");
            ps.setString(1, scheduleId);
            int s = ps.executeUpdate();
            if (s > 1) {
                System.out.println("Schedule Deleted");
            }

        } catch (Exception e) {

        }

    }

    @Override
    public List<Schedule> viewScheduledFlight()
    /**
     * Here we show list of all the schedule flight
     */
    {
        try {
            PreparedStatement pst = con.prepareStatement("Select * from schedule");

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Schedule schedule = new Schedule();
                schedule.setScheduleId(rs.getString(1));
                schedule.setSourceAirport(rs.getString(2));
                schedule.setDestinationAirport(rs.getString(3));
                schedule.setDepartureDate(rs.getString(4));
                schedule.setDepartureTime(rs.getString(5));
                schedule.setArrivalDate(rs.getString(6));
                schedule.setArrivalTime(rs.getString(7));
                scheduledFlightList.add(schedule);
            }
            return scheduledFlightList;
        } catch (Exception e) {

        }
        return null;
    }

}
