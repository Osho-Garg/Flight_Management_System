package com.capgemini.dao.Interface;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.capgemini.entities.Flight;
import com.capgemini.entities.Schedule;

public interface ScheduleDao {
	List<Schedule> scheduledFlightList = new ArrayList<>();

	Schedule scheduleFlight(Schedule scheduleFlight);

	List<Schedule> viewScheduledFlight(String source, String destination, Date ld);

	Flight viewScheduledFlight(String flightNumber);

	List<Schedule> viewScheduledFlight();

	Schedule modifyScheduledFlight(String flight, Schedule schedule);

	void deleteScheduledFlight(String scheduleId);

}
