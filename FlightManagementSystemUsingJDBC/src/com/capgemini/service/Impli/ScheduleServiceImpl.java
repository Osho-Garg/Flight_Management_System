package com.capgemini.service.Impli;
/**
 * @author
 */

import com.capgemini.dao.Interface.ScheduleDao;
import com.capgemini.entities.Flight;
import com.capgemini.entities.Schedule;
import com.capgemini.exception.NoArguementException;
import com.capgemini.exception.ScheduleNotFound;
import com.capgemini.service.Interface.ScheduleService;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class ScheduleServiceImpl implements ScheduleService {
    private ScheduleDao dao;

    public ScheduleServiceImpl(ScheduleDao dao) {
        this.dao = dao;
    }

    @Override
    public Schedule scheduleFlight(Schedule scheduleFlight) {
        if (scheduleFlight == null) {
            throw new ScheduleNotFound("Schedule is null");
        }
        Schedule schedule = dao.scheduleFlight(scheduleFlight);
        return schedule;
    }

    @Override
    public List<Schedule> viewScheduledFlight(String source, String destination, Date ld) {
        if (source == null || destination == null || ld == null) {
            throw new NoArguementException("Argument is null");
        }
        List<Schedule> schedule = new ArrayList<>();
        schedule = dao.viewScheduledFlight(source, destination, ld);
        return schedule;
    }

    @Override
    public Flight viewScheduledFlight(String flightNumber) {
        if (flightNumber == null) {
            throw new NoArguementException("Argument is null");
        }
        Flight flight = new Flight();
        flight = dao.viewScheduledFlight(flightNumber);
        return flight;
    }

    @Override
    public List<Schedule> viewScheduledFlight() {
        List<Schedule> schedule = dao.viewScheduledFlight();
        return schedule;
    }

    @Override
    public Schedule modifyScheduledFlight(String flight, Schedule schedule) {
        if (flight == null || schedule == null) {
            throw new NoArguementException("Argument is null");
        }
        Schedule schedule1 = new Schedule();
        schedule1 = dao.modifyScheduledFlight(flight, schedule);
        return schedule1;
    }

    @Override
    public void deleteScheduledFlight(String scheduleId) {
        if (scheduleId == null) {
            throw new NoArguementException("Argument is null");
        }
        dao.deleteScheduledFlight(scheduleId);

    }

}
