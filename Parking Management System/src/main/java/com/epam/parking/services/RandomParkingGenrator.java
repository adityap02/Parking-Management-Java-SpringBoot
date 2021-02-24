package com.epam.parking.services;

import java.util.ArrayList;
import java.util.Random;
import com.epam.parking.database.DatabaseModule;
import com.epam.parking.database.Vehicle;
import com.epam.parking.exceptions.IncorrectVehicleException;
import com.epam.parking.exceptions.ParkingFullException;

public class RandomParkingGenrator {
	Random generator = new Random();
	DatabaseModule databaseModule;

	public RandomParkingGenrator(DatabaseModule databaseModule) {
		this.databaseModule = databaseModule;
	}

	String randomAreaGenrator() throws IllegalArgumentException {
		if (databaseModule.parkingData.isEmpty()) {
			throw new IllegalArgumentException("No Parking Areas Found. Please Create a Parking Area First");
		}
		Object[] parkingAreas = DatabaseModule.parkingData.keySet().toArray();
		String randomArea = (String) parkingAreas[new Random().nextInt(DatabaseModule.parkingData.size())];
		if (getEmptySlotsInParkingArea(randomArea).isEmpty()) {
			randomArea = getNextEmptyParkingArea();
		}
		return randomArea;
	}

	int randomSlotGenrator(String parkingArea) {
		ArrayList<Integer> emptySlots = getEmptySlotsInParkingArea(parkingArea);
		int size = emptySlots.size();
		int index = generator.nextInt(size);
		return emptySlots.get(index);

	}

	public ArrayList<Integer> getEmptySlotsInParkingArea(String parkingArea) {
		int counter = 0;
		ArrayList<Integer> emptySlots = new ArrayList<Integer>();
		for (Vehicle v : DatabaseModule.parkingData.get(parkingArea)) {
			if (v == null) {
				emptySlots.add(counter);
			}
			counter++;
		}
		return emptySlots;
	}

	String getNextEmptyParkingArea() throws IllegalArgumentException {
		String emptyparkingArea = "";
		for (String s : DatabaseModule.parkingData.keySet()) {
			if (!getEmptySlotsInParkingArea(s).isEmpty()) {
				emptyparkingArea = s;
				return emptyparkingArea;
			}
		}
		throw new IllegalArgumentException("All Parking Areas Full");
	}
}
