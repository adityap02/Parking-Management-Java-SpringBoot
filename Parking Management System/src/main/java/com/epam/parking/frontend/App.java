package com.epam.parking.frontend;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.parking.database.DBModules;
import com.epam.parking.database.JPADatabaseModules;
import com.epam.parking.exceptions.DuplicateEntryException;
import com.epam.parking.exceptions.IncorrectVehicleException;
import com.epam.parking.services.AddNewParking;
import com.epam.parking.services.ParkVehicle;
import com.epam.parking.services.PrintAllSlots;
import com.epam.parking.services.UnparkVehicle;

public class App {
	private static final Logger LOGGER = LogManager.getLogger(App.class);
	DBModules db = new JPADatabaseModules();
	PrintOnConsole print = new PrintOnConsole();

	public void showMenu() {

		int menu;

		while (true) {
			LOGGER.info(
					"WELCOME TO PARKING MANAGEMENT \n1: Create a Parking Area\n2: Park Vehicle\n3: Unpark Vehicle\n4: Print all Slots Report\n5: Exit");
			LOGGER.info("Enter your choice: ");

			try {
				UserInput userInput = new UserInput();
				@SuppressWarnings("resource")
				Scanner input = new Scanner(System.in);
				menu = input.nextInt();

				switch (menu) {
				case 1: {
					AddNewParking addNewParking = new AddNewParking(db);
					print.printNewParkingArea(addNewParking.createNewParking(userInput.getParkingAreaFromUser(),
							userInput.getNumberOfSlotsFromUser()));

					break;
				}
				case 2: {
					ParkVehicle parkVehicle = new ParkVehicle(db);
					String vehicleNumber = userInput.getVehicleNumnberFromUser().toUpperCase();
					parkVehicle.execute(vehicleNumber);

					break;
				}
				case 3: {
					UnparkVehicle unparkVehicle = new UnparkVehicle(db);
					String vehicleNumber = userInput.getVehicleNumnberFromUser().toUpperCase();
					unparkVehicle.execute(vehicleNumber);
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
				LOGGER.warn(" Invalid Input" + e);
			} catch (DuplicateEntryException e) {
				LOGGER.warn(e);
			}catch (NullPointerException e) {
				LOGGER.warn(e);
			}
		}
	}

	public static void main(String[] args) {

		App app = new App();
		app.showMenu();

	}

}
