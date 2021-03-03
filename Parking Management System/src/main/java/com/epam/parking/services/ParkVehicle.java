package com.epam.parking.services;

import com.epam.parking.database.DatabaseModule;
import com.epam.parking.entity.Vehicle;
import com.epam.parking.exceptions.ParkingFullException;

import java.time.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ParkVehicle {
	private static final Logger LOGGER = LogManager.getLogger(ParkVehicle.class);
	DatabaseModule databaseModule;
	RandomParkingGenrator randomParking;

	public ParkVehicle(DatabaseModule databaseModule) {
		this.databaseModule = databaseModule;
	}

	public void execute(String licensePlateNumber) {
		 randomParking = new RandomParkingGenrator(databaseModule);
		try {
			String parkingArea = randomParking.randomAreaGenrator();
			int parkingSlot = randomParking.randomSlotGenrator(parkingArea);
			long inTime = getInTime();
			Vehicle v = new Vehicle(licensePlateNumber, parkingArea, parkingSlot, inTime, 0);
			databaseModule.addVehicleToSlot(v);
			databaseModule.addVehicleToLedger(licensePlateNumber, parkingArea, parkingSlot);
			LOGGER.info("Your Vehicle " + licensePlateNumber + " is Parked at Parking Area: " + parkingArea
					+ " & Slot is " + parkingSlot);
		} catch (ParkingFullException a) {
			LOGGER.warn(a.getMessage());
		}
	}

	public long getInTime() {
		Instant instant = Instant.now();
		return instant.getEpochSecond();
	}

}
