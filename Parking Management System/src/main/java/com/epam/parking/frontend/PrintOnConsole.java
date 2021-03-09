package com.epam.parking.frontend;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.parking.entity.ParkingArea;
import com.epam.parking.entity.Vehicle;

public class PrintOnConsole {
	private static final Logger LOGGER = LogManager.getLogger(PrintOnConsole.class);

	public void printNewParkingArea(ParkingArea parkingArea) {
		LOGGER.info("Parking " + parkingArea.getName() + " Created Successfully with " + parkingArea.getMaxslots()
				+ " Slots");
	}

	public void printParkedVehicle(Vehicle vehicle) {
		
			LOGGER.info("Your Vehicle " + vehicle.getLisencePlate() + " is Parked at Parking Area: " + vehicle.getParkingArea()
					+ " & Slot is " + vehicle.getParkingSlot());
		
	}
	
	public void printInfo(String s) {
		LOGGER.info(s);
	}
	public void printWarn(String s) {
		LOGGER.warn(s);
	}
}
