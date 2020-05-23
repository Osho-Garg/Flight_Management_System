package com.capgemini.entities;



public class Flight
/**
 * Class Flight
 */
{
private  int flightNumber;
private String flightModel;
private int seatCapacity;
private String carrierName;

public Flight()
/**
 * Unparametrized Contructor of flight
 */
{
	
}
public Flight(int flightNumber,String flightModel,int seatCapacity,String carrierName)
/**
 * Parameterized Constructor of flight
 */
{
this.flightNumber=flightNumber;
this.flightModel=flightModel;
this.seatCapacity=seatCapacity;
this.carrierName=carrierName;

}

	@Override
	public String toString() {
		return "Flight{" +
				"flightNumber=" + flightNumber +
				", flightModel='" + flightModel + '\'' +
				", seatCapacity=" + seatCapacity +
				", carrierName='" + carrierName + '\'' +
				'}';
	}

	public int getFlightNumber() {
	return flightNumber;
}
public void setFlightNumber(int flightNumber) {
	this.flightNumber = flightNumber;
}
public String getFlightModel() {
	return flightModel;
}
public void setFlightModel(String flightModel) {
	this.flightModel = flightModel;
}
public Integer getSeatCapacity() {
	return seatCapacity;
}
public void setSeatCapacity(int seatCapacity) {
	this.seatCapacity = seatCapacity;
}
public String getCarrierName() {
	return carrierName;
}
public void setCarrierName(String carrierName) {
	this.carrierName = carrierName;
}
}