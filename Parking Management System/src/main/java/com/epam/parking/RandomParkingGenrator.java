package com.epam.parking;
import java.math.*;
import java.util.ArrayList;
import java.util.Random;
public class RandomParkingGenrator {
	Random generator = new Random();
	String randomArea;
	App app;
	public RandomParkingGenrator(App app) {
	this.app=app;	
	}
	
	String randomAreaGenrator() {
		int limit = app.parkingData.size();
		int arr[] = new int[limit];
		Object[] parkingAreas = app.parkingData.keySet().toArray();
		randomArea = (String)parkingAreas[new Random().nextInt(app.parkingData.size())];
		System.out.println("randomArea is ::" +randomArea);
		return randomArea;
	}
	
	int randomSlotGenrator() {
				System.out.println("error checking"+app.parkingData.get(randomArea));
		int counter=0;
		ArrayList<Integer> emptySlots = new ArrayList();
		System.out.println("Slots before for loop"+emptySlots);
		for (Vehicle v : app.parkingData.get(randomArea)) {
			
			if(v==null) {
			emptySlots.add(counter);
			
			}
			counter++;
			
		}	
		int size = emptySlots.size();
		int index = generator.nextInt(size);
		
		System.out.println("Printing Empty Slots array"+emptySlots);
		System.out.println("Random slot is"+emptySlots.get(index));
		return emptySlots.get(index);
	}
	
	}

