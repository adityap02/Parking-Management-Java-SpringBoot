package com.epam.parking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ParkingBook {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "license_plate_number")
	private String licensePlateNumber;
	@Column(name = "parking_area")
	private String parkingArea;
	@Column(name = "parking_slot")
	private int parkingSlot;
	@Column(name = "in_time")
	private long inTime;
	@Column(name = "out_time")
	private long outTime;
	@Column(name = "invoice")
	private double invoice;

	public ParkingBook() {
		// TODO Auto-generated constructor stub
	}
	
	public ParkingBook(Vehicle v) {

		this.licensePlateNumber = v.getLisencePlate();
		this.parkingArea = v.getParkingArea();
		this.parkingSlot = v.getParkingSlot();
		this.inTime = v.getInTime();
		this.outTime = v.getOutTime();
		this.invoice = v.getInvoice();
	}

	public String getLicensePlateNumber() {
		return licensePlateNumber;
	}

	public void setLicensePlateNumber(String licensePlateNumber) {
		this.licensePlateNumber = licensePlateNumber;
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
