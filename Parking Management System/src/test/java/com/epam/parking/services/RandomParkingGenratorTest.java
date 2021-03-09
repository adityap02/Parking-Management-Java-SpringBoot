package com.epam.parking.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.matchers.InstanceOf;
import org.mockito.junit.jupiter.MockitoExtension;

import com.epam.parking.database.JPADatabaseModules;
import com.epam.parking.entity.ParkingArea;
import com.epam.parking.entity.SlotList;
import com.epam.parking.entity.Vehicle;
import com.epam.parking.exceptions.ParkingFullException;
import com.google.protobuf.Empty;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(OrderAnnotation.class)
class RandomParkingGenratorTest {
	@Mock
	JPADatabaseModules dbm;
	@InjectMocks
	RandomParkingGenrator randomParkingGenrator;

	List<ParkingArea> pAreaList = new ArrayList<>();

	@BeforeEach
	void setup() {
		MockitoAnnotations.initMocks(this);

	}

	@Test
	void randomParkingGenrator_ParkingFull_Test() {

		when(dbm.getParkingAreaObjectList()).thenReturn(pAreaList);
		assertThrows(ParkingFullException.class, () -> {
			randomParkingGenrator.randomAreaGenrator();
		});

	}

	@Test
	void randomParkingGenrator_Test() throws ParkingFullException {
		ParkingArea pArea1 = new ParkingArea("abc mall", 10);
		ParkingArea pArea2 = new ParkingArea("xyz mall", 20);
		pAreaList.add(pArea1);
		pAreaList.add(pArea2);

		when(dbm.getParkingAreaObjectList()).thenReturn(pAreaList);
		assertNotNull(randomParkingGenrator.randomAreaGenrator());
	}

	@Test
	void randomSlotGenrator_Test() {
		ParkingArea pArea = new ParkingArea("test", 3);
		List<SlotList> sList = new ArrayList<SlotList>();
		sList.add(new SlotList(0, "empty"));
		sList.add(new SlotList(1, "mp14mv2060"));
		sList.add(new SlotList(2, "mp24hj1897"));
		pArea.setSlots(sList);
		when(dbm.getParkingAreaObject(anyString())).thenReturn(pArea);
		assertEquals(0, randomParkingGenrator.randomSlotGenrator("test"));
	}

}
