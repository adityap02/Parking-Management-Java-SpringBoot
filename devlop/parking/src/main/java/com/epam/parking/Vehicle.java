package com.epam.parking;

public class Vehicle {
	
	String lisencePlate ;
	String parkingArea;
	int parkingSlot;
	long inTime;
	long outTime;

	
	
		public Vehicle(String lisencePlate , String parkingArea, int parkingSlot , long inTime, long outTime){
		this.lisencePlate=lisencePlate;
		this.parkingArea=parkingArea;
		this.parkingSlot=parkingSlot;
		this.inTime=inTime;
		this.outTime=outTime;
			
	}
		public long getIntime() {
			
			return inTime ;
		}
		public long getOutTime() {
			
			return outTime ;
		}
	}
