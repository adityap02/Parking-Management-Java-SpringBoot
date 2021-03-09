
package com.epam.parking.services;

import java.util.List;

import com.epam.parking.database.DBModules;
import com.epam.parking.entity.ParkingArea;
import com.epam.parking.entity.SlotList;
import com.epam.parking.frontend.PrintOnConsole;

public class PrintAllSlots {
	DBModules dbm;
	PrintOnConsole print;

	public PrintAllSlots(DBModules dbm) {
		this.dbm = dbm;
		print = new PrintOnConsole();
	}

	public void execute() throws NullPointerException{
		List<ParkingArea> pAreaList = dbm.getParkingAreaObjectList();
		if(!pAreaList.isEmpty()) {
		for (ParkingArea parkingArea : pAreaList) {
			print.printInfo(
					"**************************** \n Parking Area : " + parkingArea.getName() + "\n Slot \t Status ");

			for (SlotList s : parkingArea.getSlots()) {
				print.printInfo(s.getSlotNumber() + "    \t " + s.getSlotStatus());

			}
		}
		}
		else {
			throw new NullPointerException("No Parking Data Available");
		}	

	}

}
