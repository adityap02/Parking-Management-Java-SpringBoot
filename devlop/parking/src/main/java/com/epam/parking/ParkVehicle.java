package com.epam.parking;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.*;

public class ParkVehicle {
	Scanner input = new Scanner(System.in);
	
public void execute(App app) {
	RandomParkingGenrator rpg = new RandomParkingGenrator(app);

	System.out.println("Please Enter License Plate Number");
	String licensePlateNumber= input.nextLine();
    String parkingArea=rpg.randomAreaGenrator();
   int parkingSlot= rpg.randomSlotGenrator();
	//String parkingArea = "Aditya";
	//int parkingSlot = 12;
	long inTime = getInTime();

	Vehicle v=new Vehicle(licensePlateNumber,parkingArea,parkingSlot,inTime,0);	
	//v.outTime=20;
	addVehicleToSlot(app,v);
	addVehicleToLedger(app,licensePlateNumber,parkingArea,parkingSlot);
}	
	

public void addVehicleToSlot(App app,Vehicle v) {
	app.parkingData.get(v.parkingArea).set(v.parkingSlot,v);
	//System.out.println(app.parkingData.get(v.parkingArea));
	//System.out.println("License Plate is :" +app.parkingData.get("Aditya").get(1).lisencePlate);
	//System.out.println("Out Time is:"+ app.parkingData.get(v.parkingArea).get(v.parkingSlot-1).outTime);
}
public void addVehicleToLedger(App app,String licensePlateNumber,String parkingArea,int parkingSlot) {
	app.parkingLedger.put(licensePlateNumber, parkingArea+"-"+parkingSlot);
}



long getInTime() {
	
	Instant instant = Instant.now();
	long timeStampSeconds = instant.getEpochSecond();
	//System.out.println(timeStampSeconds);
	return timeStampSeconds;
}

public static boolean checkValidLicensePlate(String licensePlateNumber) {

	

	return true;
}
}
