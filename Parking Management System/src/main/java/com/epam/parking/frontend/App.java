package com.epam.parking.frontend;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.logging.log4j.*;

import com.epam.parking.database.DatabaseModule;
import com.epam.parking.exceptions.IncorrectVehicleException;
import com.epam.parking.services.AddNewParking;
import com.epam.parking.services.ParkVehicle;
import com.epam.parking.services.PrintAllSlots;
import com.epam.parking.services.UnparkVehicle;

public class App {
	private static final Logger LOGGER = LogManager.getLogger(App.class);
	DatabaseModule db;
	UserInput userInput = new UserInput();

	public App(DatabaseModule db) {
		this.db = db;
	}

	public void showMenu() {

		int menu;

		while (true) {
			LOGGER.info(
					"WELCOME TO PARKING MANAGEMENT \n1: Create a Parking Area\n2: Park Vehicle\n3: Unpark Vehicle\n4: Print all Slots Report\n5: Exit");
			LOGGER.info("Enter your choice: ");

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
					String vehicleNumber = userInput.getVehicleNumnberFromUser();
					if (db.isVehicleAlreadyParked(vehicleNumber)) {
						throw new IncorrectVehicleException("Vehicle Already Parked");
					} else {
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

				default:
					LOGGER.warn("Wrong Input : Please Choose Correct Option");

				}
			} catch (InputMismatchException e) {
				LOGGER.warn("Invalid Input");
				
			} catch (IncorrectVehicleException e) {
				LOGGER.warn(e+ "Invalid Input");
			}
		}
	}

	public static void main(String[] args) {

		App app = new App(new DatabaseModule());
		app.showMenu();

	}

}
