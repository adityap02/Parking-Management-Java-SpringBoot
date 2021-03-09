package com.epam.parking.services;

import com.epam.parking.database.DBModules;
import com.epam.parking.entity.Vehicle;
import com.epam.parking.exceptions.IncorrectVehicleException;
import com.epam.parking.exceptions.ParkingFullException;
import com.epam.parking.frontend.PrintOnConsole;

public class ParkVehicle {
	PrintOnConsole print;
	RandomParkingGenrator randomParking;
	GetTimestamp getTimestamp;
	DBModules dbm;

	public ParkVehicle(DBModules dbm) {
		this.dbm = dbm;
		print = new PrintOnConsole();
		randomParking = new RandomParkingGenrator(dbm);
		getTimestamp = new GetTimestamp();
	}

	public Vehicle execute(String licensePlateNumber) throws IncorrectVehicleException {
		Vehicle vehicle = null;

		try {
			if (dbm.isVehicleAlreadyParked(licensePlateNumber)) {
				throw new IncorrectVehicleException("Vehicle is Already Parked");
			} else {

				String parkingArea = randomParking.randomAreaGenrator();
				int parkingSlot = randomParking.randomSlotGenrator(parkingArea);
				long inTime = getTimestamp.getCurrentTime();
				vehicle = new Vehicle(licensePlateNumber, parkingArea, parkingSlot, inTime);
				dbm.addVehicleToSlot(vehicle);
				dbm.updateParkingArea(vehicle.getParkingArea(), vehicle.getParkingSlot(), vehicle.getLisencePlate());
			}
		} catch (ParkingFullException a) {
			 print.printWarn(a.toString());
		}
		return vehicle;
	}

}
