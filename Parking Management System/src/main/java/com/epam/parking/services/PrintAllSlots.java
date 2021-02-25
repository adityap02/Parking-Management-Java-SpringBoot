package com.epam.parking.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.parking.database.DatabaseModule;
import com.epam.parking.database.Vehicle;

public class PrintAllSlots {
	private static final Logger LOGGER = LogManager.getLogger(PrintAllSlots.class);
	DatabaseModule databaseModule;

	public PrintAllSlots(DatabaseModule databaseModule) {
		this.databaseModule = databaseModule;
	}

	public void execute() {
		

		for (String parkingArea : databaseModule.getParkingData().keySet()) {
			LOGGER.info("**************************** \n Parking Area : "+ parkingArea + "Slot \t Status ");
			int i = 0;
			for (Vehicle v : databaseModule.getParkingData().get(parkingArea)) {

				if (v == null) {
					LOGGER.info(i + "    \t " + " Vaccant ");
				} else {
					LOGGER.info(i + "    \t  " + v.getLisencePlate());
				}
				i++;
			}
		}
	}

}
