package com.epam.parking.services;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;

import com.epam.parking.database.JPADatabaseModules;
import com.epam.parking.entity.ParkingArea;
import com.epam.parking.entity.Vehicle;
import com.epam.parking.exceptions.IncorrectVehicleException;
import com.epam.parking.exceptions.ParkingFullException;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(OrderAnnotation.class)
class ParkVehicleTest {

	@Mock
	JPADatabaseModules dbm;
	@Mock
	RandomParkingGenrator randomParkingGenrator;
	@Mock
	GetTimestamp getTimestamp;
	@InjectMocks
	ParkVehicle parkVehicle;

	Vehicle v;

	@BeforeEach
	void setup() {
		MockitoAnnotations.initMocks(this);
		v = new Vehicle("mp14mv2060", "abc", 6, 1615121918);
	}

	@Test
	@Order(1)
	void alreadyParkedVehicleTest() {

		when(dbm.isVehicleAlreadyParked(anyString())).thenReturn(true);
		assertThrows(IncorrectVehicleException.class, () -> {
			parkVehicle.execute("mp14mv2060");
		});

	}

	@Test
	@Order(2)
	void alreadyParkedVehicleTest2() throws ParkingFullException {
		when(dbm.isVehicleAlreadyParked(anyString())).thenReturn(false);
		when(randomParkingGenrator.randomAreaGenrator()).thenThrow(new ParkingFullException("All Parkings are Full"));

		assertDoesNotThrow(() -> {
			parkVehicle.execute("mp14mv2060");
		});
	}

	@Test
	@Order(3)
	void parkVehicleTest() throws ParkingFullException, IncorrectVehicleException {
		when(dbm.isVehicleAlreadyParked(anyString())).thenReturn(false);

		when(randomParkingGenrator.randomAreaGenrator()).thenReturn("abc");
		when(randomParkingGenrator.randomSlotGenrator("abc")).thenReturn(6);
		when(getTimestamp.getCurrentTime()).thenCallRealMethod();
		lenient().doNothing().when(dbm).addVehicleToSlot(v);
		lenient().doNothing().when(dbm).updateParkingArea(anyString(), anyInt(), anyString());
		assertEquals(6, parkVehicle.execute("mp14mv2060").getParkingSlot());
	}

}
