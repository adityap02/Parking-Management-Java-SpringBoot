package com.epam.parking.services;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
import org.mockito.internal.matchers.Null;
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
class UnparkVehicleTest {

	@Mock
	JPADatabaseModules dbm;

	@Mock
	GetTimestamp getTimestamp;

	@InjectMocks
	UnparkVehicle unparkVehicle;

	Vehicle v, emptyVehicle;

	@BeforeEach
	void setup() {
		MockitoAnnotations.initMocks(this);
		v = new Vehicle("mp14mv2060", "abc", 6, 1615121918);

		emptyVehicle = new Vehicle();
	}

	@Test
	@Order(1)
	void unparkVehicleTest() throws IncorrectVehicleException {
		when(dbm.isVehicleAlreadyParked(anyString())).thenReturn(true);
		when(dbm.getVehicleObject(anyString())).thenReturn(v);
		// unparkVehicle.setOutTime(v);
		when(getTimestamp.getCurrentTime()).thenCallRealMethod();
		lenient().doNothing().when(dbm).updateParkingArea(v.getParkingArea(), v.getParkingSlot(), v.getLisencePlate());
		lenient().doNothing().when(dbm).removeVehicle(v.getLisencePlate());
		lenient().doNothing().when(dbm).addLogToParkingBook(v);

		assertDoesNotThrow(() -> {
			unparkVehicle.execute("mp14mv2060");
		});
	}

	@Test
	@Order(2)
	void unparkVehicle_NotParked_Test() throws IncorrectVehicleException {
		when(dbm.isVehicleAlreadyParked(anyString())).thenReturn(false);
		assertThrows(IncorrectVehicleException.class, () -> {
			unparkVehicle.execute("mp14mv2060");
		});

	}

}
