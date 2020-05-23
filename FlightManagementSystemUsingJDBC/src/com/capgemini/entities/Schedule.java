package com.capgemini.entities;

public class Schedule
/**
 * Class Schedule
 */
{
	private String scheduleId;
	private String sourceAirport;
	private String destinationAirport;
	private String arrivalDate;
	private String departureDate;
	private String departureTime;
	private String arrivalTime;

	public Schedule(String scheduleId,String sourceAirport, String destinationAirport, String arrivalDate, String departureDate,
			String departureTime, String arrivalTime)
	/**
	 * Parameterized Constuctor of Schedule
	 */
	{
		this.scheduleId=scheduleId;
		this.sourceAirport = sourceAirport;
		this.destinationAirport = destinationAirport;
		this.arrivalDate = arrivalDate;
		this.departureDate = departureDate;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
	}
	public Schedule()
	/**
	 * Unparameterized Constructor of Schedule
	 */
	{

	}
	
	public String getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(String scheduleId) {
		this.scheduleId = scheduleId;
	}
	public String getSourceAirport() {
		return sourceAirport;
	}
	public void setSourceAirport(String sourceAirport) {
		this.sourceAirport = sourceAirport;
	}
	public String getDestinationAirport() {
		return destinationAirport;
	}
	public void setDestinationAirport(String destinationAirport) {
		this.destinationAirport = destinationAirport;
	}
	public String getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	public String getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	
	
	
}
