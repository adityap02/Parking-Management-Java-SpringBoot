package com.epam.parking.services;

import com.epam.parking.database.DBModules;
import com.epam.parking.entity.ParkingArea;
import com.epam.parking.exceptions.DuplicateEntryException;

public class AddNewParking {
	RandomParkingGenrator rpg;
	DBModules dbm;

	public AddNewParking(DBModules dbm) {
		this.dbm = dbm;
	}

	public ParkingArea createNewParking(String parkingName, int numberOfParkingSlots) throws DuplicateEntryException {
		ParkingArea pArea = dbm.getParkingAreaObject(parkingName);
		if (pArea== null) {
			pArea = dbm.addNewParkingArea(parkingName, numberOfParkingSlots);
		} else {
			throw new DuplicateEntryException("Parking Name " + parkingName + " Already Exists");
		}
		return pArea;
	}

}
