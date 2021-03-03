package com.epam.parking.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import com.epam.parking.database.DatabaseModule;
import com.epam.parking.entity.Vehicle;
import com.epam.parking.exceptions.ParkingFullException;

public class RandomParkingGenrator {
	Random generator = new Random();
	DatabaseModule databaseModule;

	public RandomParkingGenrator(DatabaseModule databaseModule) {
		this.databaseModule = databaseModule;
	}

	String randomAreaGenrator() throws ParkingFullException {
		if (databaseModule.getParkingData().isEmpty()) {
			throw new IllegalArgumentException("No Parking Areas Found. Please Create a Parking Area First");
		}
		Object[] parkingAreas = databaseModule.getParkingData().keySet().toArray();
		String randomArea = (String) parkingAreas[new Random().nextInt(databaseModule.getParkingData().size())];
		if (getEmptySlotsInParkingArea(randomArea).isEmpty()) {
			randomArea = getNextEmptyParkingArea();
		}
		return randomArea;
	}

	int randomSlotGenrator(String parkingArea) {
		List<Integer> emptySlots = getEmptySlotsInParkingArea(parkingArea);
		int size = emptySlots.size();
		int index = generator.nextInt(size);
		return emptySlots.get(index);

	}

	public List<Integer> getEmptySlotsInParkingArea(String parkingArea) {
		int counter = 0;
		List<Integer> emptySlots = new ArrayList<>();
		for (Vehicle v : databaseModule.getParkingData().get(parkingArea)) {
			if (v == null) {
				emptySlots.add(counter);
			}
			counter++;
		}
		return emptySlots;
	}

	String getNextEmptyParkingArea() throws ParkingFullException {
		String emptyparkingArea = "";
		for (String s : databaseModule.getParkingData().keySet()) {
			if (!getEmptySlotsInParkingArea(s).isEmpty()) {
				emptyparkingArea = s;
				return emptyparkingArea;
			}
		}
		throw new ParkingFullException("All Parking Areas Full");
	}
}
