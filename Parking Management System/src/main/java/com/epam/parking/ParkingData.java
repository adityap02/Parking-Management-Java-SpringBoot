package com.epam.parking;

//import java.util.HashMap;
import java.util.*;

public class ParkingData {
	String name;
	ArrayList<Vehicle> v;
	ArrayList<Vehicle> veh = new ArrayList<>();
	
	
	
	
	public void setParkingData(String name, ArrayList<Vehicle> v ) {
		this.name=name;
		this.v=v;
	//	parkingData.put(name,v);
		//System.out.println("New Parking Created : "+parkingData);
	}
	
	void testmethod() {
		
	}
	
}
