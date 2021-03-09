package com.epam.parking.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.epam.parking.database.JPADatabaseModules;
import com.epam.parking.entity.ParkingArea;
import com.epam.parking.entity.SlotList;
@ExtendWith(MockitoExtension.class)
@TestMethodOrder(OrderAnnotation.class)
class PrintAllSlotsTest {
	@Mock
	JPADatabaseModules dbm;
	@InjectMocks
	PrintAllSlots printAllSlots;
	List<ParkingArea> pAreaList = new ArrayList<>();
	
	@BeforeEach
	void setup() {
		MockitoAnnotations.initMocks(this);
		ParkingArea pArea = new ParkingArea("test", 3);
		List<SlotList> sList = new ArrayList<SlotList>();
		sList.add(new SlotList(0, "empty"));
		sList.add(new SlotList(1, "mp14mv2060"));
		sList.add(new SlotList(2, "mp24hj1897"));
		pArea.setSlots(sList);
		pAreaList.add(pArea);
		 
	}
	
	@Test
	void printAllSlotsTest() {
		when(dbm.getParkingAreaObjectList()).thenReturn(pAreaList);
		assertDoesNotThrow(()->{
			printAllSlots.execute();
		});
	}

	@Test
	void printAllSlots_NoData_Test() {
		List<ParkingArea> emptyParkingAreaList= new ArrayList<>();
		when(dbm.getParkingAreaObjectList()).thenReturn(emptyParkingAreaList);
		assertThrows(NullPointerException.class,()->{
			printAllSlots.execute();
		});
	}
}
