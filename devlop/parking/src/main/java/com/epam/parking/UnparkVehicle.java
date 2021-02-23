package com.epam.parking;

import java.time.Instant;
import java.util.Scanner;

public class UnparkVehicle {
	static final int RATE=7;  
	App app;
	String licensePlateNumber,parkedSlot;
	Scanner input = new Scanner(System.in);
	//Vehicle v = app.parkingData.get("Aditya").get(2);
	UnparkVehicle(App app){
		this.app=app;
	}
	
	
	void getVehicleNumberToUnpark() {
		System.out.println("Enter Vehicle License Plate Number to Unpark");
		licensePlateNumber = input.nextLine();
		
		try {
			
		if(ParkVehicle.checkValidLicensePlate(licensePlateNumber)) {
		String parkedSlot = app.parkingLedger.get(licensePlateNumber).toString();
		String[] slot = parkedSlot.split("-");
		String parkingArea = slot[0];
		int parkingSlot = Integer.parseInt(slot[1]);
		Vehicle v = app.parkingData.get(parkingArea).get(parkingSlot);
		setOutTime(v);
		double invoice = createInvoice(v);
		app.parkingData.get(slot[0]).set((parkingSlot), null);
		app.parkingLedger.remove(licensePlateNumber);
		System.out.println("Your Vehicle number : "+licensePlateNumber+"is unparked from Slot"+slot[0]+"-"+slot[1]);
		System.out.println("Your Parking Invoice is of Rupees : "+invoice);
		}
		else{
			throw new Exception("Please Enter Correct License Plate Number");
		}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	 double createInvoice(Vehicle v){
		return RATE*(int)((v.outTime-v.inTime));
	}
	 
	void setOutTime(Vehicle v) {
		Instant instant = Instant.now();
		long timeStampSeconds = instant.getEpochSecond();
		v.outTime=timeStampSeconds;
	}
	
	}
