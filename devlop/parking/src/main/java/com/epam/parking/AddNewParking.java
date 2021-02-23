package com.epam.parking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AddNewParking {
	Scanner input = new Scanner(System.in);

	void createNewParking(App app) {
		System.out.println("Please Enetr a Name for your parking");
		String parkingName = input.nextLine();
		System.out.println("Enter Number of slots in parking");
		int numberOfSlots= input.nextInt();
	
		//ParkingData p = new ParkingData();
		app.parkingData.put(parkingName,new ArrayList<>(Arrays.asList(new Vehicle [numberOfSlots])));
		System.out.println(app.parkingData);
	}
	
}
