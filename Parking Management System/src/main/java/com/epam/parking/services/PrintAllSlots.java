package com.epam.parking.services;

import com.epam.parking.database.DatabaseModule;
import com.epam.parking.database.Vehicle;

public class PrintAllSlots {

	DatabaseModule databaseModule;

	public PrintAllSlots(DatabaseModule databaseModule) {
		this.databaseModule = databaseModule;
	}

	public void execute() {
		

		for (String parkingArea : databaseModule.parkingData.keySet()) {
			System.out.println("****************************");
			System.out.println("Parking Area :" + parkingArea);
			System.out.println("Slot \t Status ");
			int i = 0;
			for (Vehicle v : databaseModule.parkingData.get(parkingArea)) {

				if (v == null) {
					System.out.println(i + "    \t " + " Vaccant ");
				} else {
					System.out.println(i + "    \t  " + v.lisencePlate);
				}
				i++;
			}
		}
	}

}
