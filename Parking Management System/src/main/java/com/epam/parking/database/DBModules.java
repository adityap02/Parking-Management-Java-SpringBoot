package com.epam.parking.database;

import java.util.List;

import com.epam.parking.entity.ParkingArea;
import com.epam.parking.entity.Vehicle;
import com.epam.parking.exceptions.DuplicateEntryException;
import com.epam.parking.exceptions.ParkingFullException;

public interface DBModules {

	ParkingArea addNewParkingArea(String parkingName, int numberOfParkingSlots) throws DuplicateEntryException;

	public ParkingArea getParkingAreaObject(String parkingArea);

	public List<ParkingArea> getParkingAreaObjectList();

	void addVehicleToSlot(Vehicle v);

	boolean isVehicleAlreadyParked(String licensePlateNumber);

	String getParkingArea(String licensePlateNumber);

	int getParkingSlot(String licensePlateNumber);

	void removeVehicle(String licensePlateNumber);

	Vehicle getParkedVehicle(String licensePlateNumber);

	ParkingArea getRandomParkingArea() throws ParkingFullException;

	Vehicle getVehicleObject(String licensePlateNumber);

	void updateParkingArea(String parkingArea, int slot, String licensePlateNumber);

	void addLogToParkingBook(Vehicle v);
}
