package com.capgemini.service.Interface;

import com.capgemini.entities.Flight;
import com.capgemini.entities.Schedule;

import java.sql.Date;
import java.util.List;

public interface ScheduleService {

	Schedule scheduleFlight(Schedule scheduleFlight);

	List<Schedule> viewScheduledFlight(String source, String destination, Date ld);

	Flight viewScheduledFlight(String flightNumber);

	List<Schedule> viewScheduledFlight();

	Schedule modifyScheduledFlight(String flight, Schedule schedule);

	void deleteScheduledFlight(String scheduleId);
}
