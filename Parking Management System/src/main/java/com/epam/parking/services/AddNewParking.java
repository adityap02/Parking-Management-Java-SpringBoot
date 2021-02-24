package com.epam.parking.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import com.epam.parking.database.DatabaseModule;
import com.epam.parking.database.Vehicle;
import com.epam.parking.frontend.UserInput;

public class AddNewParking {
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
		System.out.println("Parking "+parkingName+" Created Successfully with "+ numberOfParkingSlots + " Slots");
		}catch (Exception e) {
			System.out.println("Parking Name: "+parkingName+" Already Exists. Please Enter a New Parking Name");
		}
		
	}

}
