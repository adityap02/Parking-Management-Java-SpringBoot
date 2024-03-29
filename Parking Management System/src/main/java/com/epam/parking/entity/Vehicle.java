package com.epam.parking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "parked_vehicle")
public class Vehicle {
	@Id
	@Column(length = 60)
	private String lisencePlate;
	private String parkingArea;
	private int parkingSlot;
	private long inTime;
	private long outTime;
	private double invoice;

	public Vehicle() {
	}

	public Vehicle(String lisencePlate, String parkingArea, int parkingSlot, long inTime) {
		this.lisencePlate = lisencePlate;
		this.parkingArea = parkingArea;
		this.parkingSlot = parkingSlot;
		this.inTime = inTime;
		this.outTime = 0;
		this.invoice = 0;

	}

	public String getLisencePlate() {
		return lisencePlate;
	}

	public void setLisencePlate(String lisencePlate) {
		this.lisencePlate = lisencePlate;
	}

	public String getParkingArea() {
		return parkingArea;
	}

	public void setParkingArea(String parkingArea) {
		this.parkingArea = parkingArea;
	}

	public int getParkingSlot() {
		return parkingSlot;
	}

	public void setParkingSlot(int parkingSlot) {
		this.parkingSlot = parkingSlot;
	}

	public long getInTime() {
		return inTime;
	}

	public void setInTime(long inTime) {
		this.inTime = inTime;
	}

	public long getOutTime() {
		return outTime;
	}

	public void setOutTime(long outTime) {
		this.outTime = outTime;
	}

	public double getInvoice() {
		return invoice;
	}

	public void setInvoice(double invoice) {
		this.invoice = invoice;
	}

}
