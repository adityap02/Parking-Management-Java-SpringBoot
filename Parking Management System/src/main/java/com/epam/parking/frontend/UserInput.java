package com.epam.parking.frontend;

import java.util.Scanner;

import com.epam.parking.exceptions.IncorrectVehicleException;

public class UserInput {
	Scanner input = new Scanner(System.in);

	public String getVehicleNumnberFromUser() throws IncorrectVehicleException {
		System.out.println("Please Enter License Plate Number");
		String licensePlateNumber = input.nextLine();
		if (checkValidLicensePlate(licensePlateNumber)) {
			return licensePlateNumber;
		}
		throw new IncorrectVehicleException("Please Enter License Plate Number in Correct Format. Eg : mp14mv2060");
	}

	public String getParkingAreaFromUser() {
		System.out.println("Please Enter a Name for your parking");
		String parkingName = input.nextLine();
		return parkingName;
	}

	public int getNumberOfSlotsFromUser() {
		System.out.println("Enter Number of slots in Parking Area");
		int numberOfParkingSlots = input.nextInt();
		return numberOfParkingSlots;
	}

	public static boolean checkValidLicensePlate(String licensePlateNumber) {
		return licensePlateNumber.matches("^[a-zA-Z]{2}[0-9]{2}[a-zA-Z]{2}[0-9]{4}$");
	}
}
