package com.epam.parking.database;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DatabaseModule {

	public static Map<String, ArrayList<Vehicle>> parkingData = new HashMap<>();
	public static Map<String, String> parkingLedger = new HashMap();

	public void addNewParkingArea(String parkingName, int numberOfParkingSlots) throws Exception {
		if (parkingData.containsKey(parkingName)) {
			throw new Exception("Parking Name: " + parkingName + " Already Exists");
		} else
			parkingData.put(parkingName, new ArrayList<>(Arrays.asList(new Vehicle[numberOfParkingSlots])));
	}

	public void addVehicleToSlot(Vehicle v) {
		parkingData.get(v.parkingArea).set(v.parkingSlot, v);
	}

	public void addVehicleToLedger(String licensePlateNumber, String parkingArea, int parkingSlot) {
		parkingLedger.put(licensePlateNumber, parkingArea + "-" + parkingSlot);
	}

	public boolean isVehicleAlreadyParked(String licensePlateNumber) {
		return parkingLedger.containsKey(licensePlateNumber);
	}

	public String getParkingArea(String licensePlateNumber) {

		String parkingArea[] = DatabaseModule.parkingLedger.get(licensePlateNumber).toString().split("-");
		return parkingArea[0];
	}

	public int getParkingSlot(String licensePlateNumber) {
		String parkingSlot[] = DatabaseModule.parkingLedger.get(licensePlateNumber).toString().split("-");
		return Integer.parseInt(parkingSlot[1]);
	}

	public void removeVehicleFromParkingData(String parkingArea, int parkingSlot) {
		parkingData.get(parkingArea).set((parkingSlot), null);
	}

	public void removeVehicleFromParkingLedger(String licensePlateNumber) {
		parkingLedger.remove(licensePlateNumber);
	}
}
