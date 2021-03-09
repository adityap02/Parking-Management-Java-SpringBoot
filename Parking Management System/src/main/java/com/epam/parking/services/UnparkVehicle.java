package com.epam.parking.services;

import com.epam.parking.database.DBModules;
import com.epam.parking.entity.Vehicle;
import com.epam.parking.exceptions.IncorrectVehicleException;
import com.epam.parking.frontend.PrintOnConsole;

public class UnparkVehicle {
	PrintOnConsole print;
	static final int RATE = 7;
	GetTimestamp getTimeStamp;
	DBModules dbm;

	public UnparkVehicle(DBModules dbm) {
		print = new PrintOnConsole();
		this.dbm = dbm;
		getTimeStamp = new GetTimestamp();
	}

	public void execute(String licensePlateNumber) throws IncorrectVehicleException {

		if (!dbm.isVehicleAlreadyParked(licensePlateNumber)) {
			throw new IncorrectVehicleException("Vehicle is Not Parked Yet");
		} else {
			Vehicle v = dbm.getVehicleObject(licensePlateNumber);
			double invoice = createInvoice(v);
			v.setInvoice(invoice);
			dbm.updateParkingArea(v.getParkingArea(), v.getParkingSlot(), "empty");
			dbm.removeVehicle(licensePlateNumber);
			dbm.addLogToParkingBook(v);
			print.printInfo("******************* \n Your Vehicle number : " + licensePlateNumber
					+ "is unparked from Parking Area : " + v.getParkingArea() + " Slot " + v.getParkingSlot());

			print.printInfo("Your Parking Invoice is of Rupees : " + invoice + "\n *******************");
		}

	}

	double createInvoice(Vehicle v) {
		setOutTime(v);
		double seconds = v.getOutTime() - v.getInTime();
		return RATE * (seconds / 60);
	}

	void setOutTime(Vehicle v) {
		v.setOutTime(getTimeStamp.getCurrentTime());
	}

}
