package com.epam.parking.services;

import com.epam.parking.database.DatabaseModule;
import com.epam.parking.database.Vehicle;


import java.time.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ParkVehicle {
	private static final Logger LOGGER = LogManager.getLogger(ParkVehicle.class);
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
			LOGGER.info("Your Vehicle " + licensePlateNumber + " is Parked at Parking Area: " + parkingArea
					+ " & Slot is " + parkingSlot);
		} catch (IllegalArgumentException a) {
			LOGGER.warn(a.getMessage());
		}
	}

	long getInTime() {
		Instant instant = Instant.now();
		return instant.getEpochSecond();
	}

}
