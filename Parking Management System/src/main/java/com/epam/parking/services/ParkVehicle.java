package com.epam.parking.services;

import com.epam.parking.database.DatabaseModule;
import com.epam.parking.database.Vehicle;
import com.epam.parking.exceptions.IncorrectVehicleException;

import java.time.*;

public class ParkVehicle {
	DatabaseModule databaseModule;
	RandomParkingGenrator randomParking = new RandomParkingGenrator(databaseModule);

	public ParkVehicle(DatabaseModule databaseModule) {
		this.databaseModule = databaseModule;
	}

	public void execute(String licensePlateNumber) {

		try {
			String parkingArea = randomParking.randomAreaGenrator();
			int parkingSlot = randomParking.randomSlotGenrator(parkingArea);
			long inTime = getInTime();
			Vehicle v = new Vehicle(licensePlateNumber, parkingArea, parkingSlot, inTime, 0);
			databaseModule.addVehicleToSlot(v);
			databaseModule.addVehicleToLedger(licensePlateNumber, parkingArea, parkingSlot);
			System.out.println("Your Vehicle " + licensePlateNumber + " is Parked at Parking Area: " + parkingArea
					+ " & Slot is " + parkingSlot);
		} catch (IllegalArgumentException a) {
			System.out.println(a.getMessage());
		}
	}

	long getInTime() {
		Instant instant = Instant.now();
		long timeStampSeconds = instant.getEpochSecond();
		return timeStampSeconds;
	}

}
