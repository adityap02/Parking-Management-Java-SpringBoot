package com.epam.parking.entity;

public class Vehicle {

	private String lisencePlate;
	private String parkingArea;
	private int parkingSlot;
	private long inTime;
	private long outTime;

	public Vehicle(String lisencePlate, String parkingArea, int parkingSlot, long inTime, long outTime) {
		this.lisencePlate = lisencePlate;
		this.parkingArea = parkingArea;
		this.parkingSlot = parkingSlot;
		this.inTime = inTime;
		this.outTime = outTime;

	}

	//Getters
	public long getIntime() {
		return inTime;
	}

	public long getOutTime() {
		return outTime;
	}

	public int getParkingSlot() {
		return parkingSlot;
	}
	public String getParkingArea() {
		return parkingArea;
	}
	public String getLisencePlate() {
		return lisencePlate;
	}

	//Setters
	public void setOutTime(long outTime) {
		this.outTime = outTime;
	}

	public void setinTime(long inTime) {
		this.inTime = inTime;
	}

	public void setParkingSlot(int parkingSlot) {
		this.parkingSlot = parkingSlot;
	}
	public void setParkingArea(String parkingArea) {
		this.parkingArea = parkingArea;
	}
	public void setLisencePlate(String lisencePlate) {
		this.lisencePlate = lisencePlate;
	}
}
