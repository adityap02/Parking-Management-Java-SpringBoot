package com.epam.parking.frontend;

import java.util.ArrayList;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.parking.entity.Vehicle;
import com.epam.parking.services.PrintAllSlots;

public class PrintSlots {
		
	private static final Logger LOGGER = LogManager.getLogger(PrintAllSlots.class);
	
	public void printSlots(Map<String, ArrayList<Vehicle>> parkingData) {
		for (String parkingArea : parkingData.keySet()) {
			LOGGER.info("**************************** \n Parking Area : "+ parkingArea + "Slot \t Status ");
			int i = 0;
			for (Vehicle v : parkingData.get(parkingArea)) {

				if (v == null) {
					LOGGER.info(i + "    \t " + " Vaccant ");
				} else {
					LOGGER.info(i + "    \t  " + v.getLisencePlate());
				}
				i++;
			}
		}
	}
	

}
