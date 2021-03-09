package com.epam.parking.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.epam.parking.database.JPADatabaseModules;
import com.epam.parking.entity.ParkingArea;
import com.epam.parking.exceptions.DuplicateEntryException;

@RunWith(MockitoJUnitRunner.class)
class AddNewParkingTest2 {

	@Mock
	JPADatabaseModules dbm;
	@InjectMocks
	ParkVehicle addNewParking;
	
	ParkingArea pArea;

	@BeforeEach
	void setup() {
		MockitoAnnotations.initMocks(this);
		
		pArea = new ParkingArea();
		pArea.setName("aditya");
		pArea.setMaxslots(10);

	}

	@Test
	void addNewParkingAreaTest() throws DuplicateEntryException {
		/*
		 * when(dbm.getParkingAreaObject(anyString())).thenReturn(null);
		 * when(dbm.addNewParkingArea("aditya",10)).thenReturn(pArea);
		 * assertEquals("aditya", addNewParking.createNewParking("aditya",
		 * 10).getName()); assertEquals(10, addNewParking.createNewParking("aditya",
		 * 10).getMaxslots());
		 */
	}
	
	@Test
	void addDuplicateParkingAreaTest() throws DuplicateEntryException {
		/*
		 * when(dbm.getParkingAreaObject("aditya")).thenReturn(pArea);
		 * assertThrows(DuplicateEntryException.class, ()->{
		 * addNewParking.createNewParking("aditya", 10); });
		 */
	
	}
	
}
