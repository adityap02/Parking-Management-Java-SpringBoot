package com.epam.parking.frontend;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.parking.exceptions.IncorrectVehicleException;

public class UserInput {
	private static final Logger LOGGER = LogManager.getLogger(UserInput.class);
	Scanner input = new Scanner(System.in);

	public String getVehicleNumnberFromUser() throws IncorrectVehicleException {
		LOGGER.info("Please Enter License Plate Number");
		String licensePlateNumber = input.nextLine();
		if (checkValidLicensePlate(licensePlateNumber)) {
			return licensePlateNumber;
		}
		throw new IncorrectVehicleException("Please Enter License Plate Number in Correct Format. Eg : mp14mv2060");
	}

	public String getParkingAreaFromUser() {
		LOGGER.info("Please Enter a Name for your parking");
		return input.nextLine();
	}

	public int getNumberOfSlotsFromUser() {
		LOGGER.info("Enter Number of slots in Parking Area");
		return input.nextInt();
	}

	public static boolean checkValidLicensePlate(String licensePlateNumber) {
		return licensePlateNumber.matches("^[a-zA-Z]{2}[0-9]{2}[a-zA-Z]{2}[0-9]{4}$");
	}
}
