package com.epam.parking.services;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.parking.database.DatabaseModule;
import com.epam.parking.exceptions.DuplicateEntryException;
import com.epam.parking.frontend.UserInput;

public class AddNewParking {
	private static final Logger LOGGER = LogManager.getLogger(AddNewParking.class);
	DatabaseModule databaseModule;
	UserInput userInput = new UserInput();

	public AddNewParking(DatabaseModule databaseModule) {
		this.databaseModule = databaseModule;
	}

	Scanner input = new Scanner(System.in);

	public void createNewParking() {
		String parkingName = userInput.getParkingAreaFromUser();
		int numberOfParkingSlots = userInput.getNumberOfSlotsFromUser();
		try {
			databaseModule.addNewParkingArea(parkingName, numberOfParkingSlots);
			LOGGER.info("Parking " + parkingName + " Created Successfully with " + numberOfParkingSlots + " Slots");
		} catch (DuplicateEntryException e) {
			LOGGER.warn(e);
		}

	}

}
