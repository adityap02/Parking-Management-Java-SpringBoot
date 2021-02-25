package com.epam.parking.services;

import java.time.Instant;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.parking.database.DatabaseModule;
import com.epam.parking.database.Vehicle;

public class UnparkVehicle {
	private static final Logger LOGGER = LogManager.getLogger(UnparkVehicle.class);
	static final int RATE = 7;
	DatabaseModule databaseModule;
	String licensePlateNumber;
	String parkedSlot;

	public UnparkVehicle(DatabaseModule databaseModule) {
		this.databaseModule = databaseModule;
	}

	public void execute(String licensePlateNumber) {
		try {
			String parkingArea = databaseModule.getParkingArea(licensePlateNumber);
			int parkingSlot = databaseModule.getParkingSlot(licensePlateNumber);
			databaseModule.removeVehicleFromParkingLedger(licensePlateNumber);
			Vehicle v = databaseModule.getParkingData().get(parkingArea).get(parkingSlot);
			setOutTime(v);
			double invoice = createInvoice(v);
			databaseModule.removeVehicleFromParkingData(parkingArea, parkingSlot);
			LOGGER.info("******************* \n Your Vehicle number : " + licensePlateNumber
					+ "is unparked from Parking Area : " + parkingArea + " Slot " + parkingSlot);

			LOGGER.info("Your Parking Invoice is of Rupees : " + invoice + "\n *******************");

		} catch (NullPointerException e) {
			LOGGER.warn("This Vehicle is not already parked ");
		}
	}

	double createInvoice(Vehicle v) {
		return RATE * (double) (v.getOutTime() - v.getIntime());
	}

	void setOutTime(Vehicle v) {
		Instant instant = Instant.now();
		long timeStampSeconds = instant.getEpochSecond();
		v.setOutTime(timeStampSeconds);
	}

}
