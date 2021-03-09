package com.epam.parking.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.epam.parking.database.DBModules;
import com.epam.parking.database.JPADatabaseModules;
import com.epam.parking.entity.ParkingArea;
import com.epam.parking.entity.SlotList;
import com.epam.parking.exceptions.ParkingFullException;

public class RandomParkingGenrator {
	DBModules dbm;

	public RandomParkingGenrator(DBModules dbm) {
		this.dbm = dbm;
	}

	String randomAreaGenrator() throws ParkingFullException {
		List<ParkingArea> pAreaList = dbm.getParkingAreaObjectList();
		if (pAreaList.isEmpty()) {
			throw new ParkingFullException("No Empty Parking Areas");
		}
		return pAreaList.get(new Random().nextInt(pAreaList.size())).getName();
	}

	int randomSlotGenrator(String parkingArea) {
		ParkingArea pArea = dbm.getParkingAreaObject(parkingArea);
		List<SlotList> emptySlots = getEmptySlotsInParkingArea(pArea.getSlots());
		int size = emptySlots.size();
		int index = new Random().nextInt(size);
		return emptySlots.get(index).getSlotNumber();
	}

	public List<SlotList> getEmptySlotsInParkingArea(List<SlotList> slotsList) {
		List<SlotList> emptySlots = new ArrayList<>();
		for (SlotList s : slotsList) {
			if (s.getSlotStatus().equals("empty")) {
				emptySlots.add(s);
			}
		}
		return emptySlots;
	}
}
