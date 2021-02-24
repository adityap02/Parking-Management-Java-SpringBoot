package com.epam.parking.frontend;

import java.util.*;

import com.epam.parking.database.*;
import com.epam.parking.exceptions.IncorrectVehicleException;
import com.epam.parking.services.*;

public class App {

	DatabaseModule db;
	UserInput userInput = new UserInput();

	App(DatabaseModule db) {
		this.db = db;
	}

	void showMenu() {

		int menu;

		while (true) {

			System.out.println("WELCOME TO PARKING MANAGEMENT");
			System.out.println("1: Create a Parking Area");
			System.out.println("2: Park Vehicle");
			System.out.println("3: Unpark Vehicle");
			System.out.println("4: Print all Slots Report");
			System.out.println("5: Exit");

			System.out.print("Enter your choice: ");
			try {
				Scanner input = new Scanner(System.in);
				menu = input.nextInt();

				switch (menu) {
				case 1: {
					AddNewParking addNewParking = new AddNewParking(db);
					addNewParking.createNewParking();
					break;
				}
				case 2: {
					ParkVehicle parkVehicle = new ParkVehicle(db);
					String vehicleNumber= userInput.getVehicleNumnberFromUser();
					if(db.isVehicleAlreadyParked(vehicleNumber)) {
						throw new IncorrectVehicleException("Vehicle Already Parked");
					}else {
					parkVehicle.execute(vehicleNumber);
					}
					break;
				}
				case 3: {
					UnparkVehicle unparkVehicle = new UnparkVehicle(db);
					unparkVehicle.execute(userInput.getVehicleNumnberFromUser());
					break;
				}

				case 4: {
					PrintAllSlots printAllSlots = new PrintAllSlots(db);
					printAllSlots.execute();
					break;
				}

				case 5: {
					System.exit(0);
					break;
				}

				default: {
					System.out.println("Please Choose Correct Option");
				}

				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid Input");
				continue;
			}catch (IncorrectVehicleException e) {
				System.out.println(e);
			}
		}
	}

	public static void main(String[] args) {

		App app = new App(new DatabaseModule());
		app.showMenu();

	}

}
