package com.capgemini.entities;

public class ScheduleFlight {
	int scheduleFlightId;
	int availableSeats;
	double ticketCost;

	public ScheduleFlight()
	{
		
	}
	
	public ScheduleFlight(int scheduleFlightId, int availableSeats, double ticketCost) {
		super();
		this.scheduleFlightId = scheduleFlightId;
		this.availableSeats = availableSeats;
		this.ticketCost = ticketCost;
	}

	public int getScheduleFlightId() {
		return scheduleFlightId;
	}
	public void setScheduleFlightId(int scheduleFlightId) {
		this.scheduleFlightId = scheduleFlightId;
	}
	public int getAvailableSeats() {
		return availableSeats;
	}
	
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	public double getTicketCost() {
		return ticketCost;
	}
	public void setTicketCost(double ticketCost) {
		this.ticketCost = ticketCost;
	}

	@Override
	public String toString() {
		return "ScheduleFlight{" +
				"scheduleFlightId=" + scheduleFlightId +
				", availableSeats=" + availableSeats +
				", ticketCost=" + ticketCost +
				'}';
	}
}
