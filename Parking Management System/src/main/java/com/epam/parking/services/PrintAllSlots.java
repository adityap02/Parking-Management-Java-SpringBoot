
package com.epam.parking.services;

import com.epam.parking.database.DatabaseModule;
import com.epam.parking.frontend.PrintSlots;

public class PrintAllSlots {

	DatabaseModule databaseModule;
	PrintSlots print;

	public PrintAllSlots(DatabaseModule databaseModule) {
		this.databaseModule = databaseModule;
		print = new PrintSlots();
	}

	public void execute() {
		print.printSlots(databaseModule.getParkingData());
	}

}
