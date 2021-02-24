package com.epam.parking.services;

import java.time.Instant;
import java.util.Scanner;

import com.epam.parking.database.DatabaseModule;
import com.epam.parking.database.Vehicle;
import com.epam.parking.frontend.App;

public class UnparkVehicle {
	static final int RATE = 7;
	DatabaseModule databaseModule;
	String licensePlateNumber, parkedSlot;

	public UnparkVehicle(DatabaseModule databaseModule) {
		this.databaseModule = databaseModule;
	}

	public void execute(String licensePlateNumber) {
		try {
		String parkingArea = databaseModule.getParkingArea(licensePlateNumber);
		int parkingSlot = databaseModule.getParkingSlot(licensePlateNumber);
		databaseModule.removeVehicleFromParkingLedger(licensePlateNumber);
		Vehicle v = DatabaseModule.parkingData.get(parkingArea).get(parkingSlot);
		setOutTime(v);
		double invoice = createInvoice(v);
		databaseModule.removeVehicleFromParkingData(parkingArea, parkingSlot);
		System.out.println("*******************");
		System.out.println("Your Vehicle number : " + licensePlateNumber + "is unparked from Parking Area : "
				+ parkingArea + " Slot " + parkingSlot);
		System.out.println("Your Parking Invoice is of Rupees : " + invoice);
		System.out.println("*******************");
		}catch (NullPointerException e) {
			System.out.println("This Vehicle is not already parked ");
		}
	}

	double createInvoice(Vehicle v) {
		return RATE * (int) ((v.outTime - v.inTime));
	}

	void setOutTime(Vehicle v) {
		Instant instant = Instant.now();
		long timeStampSeconds = instant.getEpochSecond();
		v.outTime = timeStampSeconds;
	}

}
