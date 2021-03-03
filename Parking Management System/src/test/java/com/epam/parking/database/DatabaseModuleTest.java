package com.epam.parking.database;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.epam.parking.entity.Vehicle;
import com.epam.parking.exceptions.DuplicateEntryException;

class DatabaseModuleTest {

	static DatabaseModule databaseModule;
	static Vehicle vehicle;

	@BeforeAll
	public static void init() throws DuplicateEntryException, IllegalArgumentException {
		databaseModule = new DatabaseModule();

		databaseModule.addNewParkingArea("ABC Shopping Mall", 3);
		vehicle = new Vehicle("MP14MV2060", "ABC Shopping Mall", 1, 1614599136, 0);
	}

	@Test
	void testAddNewParkingArea() {
		assertEquals(true, databaseModule.getParkingData().containsKey("ABC Shopping Mall"));
	}

	@Test
	void testAddNewParkingAreaDuplicate() {
		assertThrows(DuplicateEntryException.class, () -> {
			databaseModule.addNewParkingArea("ABC Shopping Mall", 2);
		});
	}

	@Test
	void testAddVehicleToSlot() {
		databaseModule.addVehicleToSlot(vehicle);
		assertEquals(true, databaseModule.getParkingData().get(vehicle.getParkingArea()).contains(vehicle));
	}

	@Test
	void testAddVehicleToLedger() {
		databaseModule.addVehicleToLedger(vehicle.getLisencePlate(), vehicle.getParkingArea(),
				vehicle.getParkingSlot());
		assertEquals(true, databaseModule.getParkingLedger().containsKey(vehicle.getLisencePlate()));
	}

	@Test
	void testIsVehicleAlreadyParked() {
		assertEquals(true, databaseModule.isVehicleAlreadyParked(vehicle.getLisencePlate()));
	}

	@Test
	void testGetParkingArea() {
		assertEquals(vehicle.getParkingArea(), databaseModule.getParkingArea(vehicle.getLisencePlate()));
	}

	@Test
	void testGetParkingSlot() {
		assertEquals(vehicle.getParkingSlot(), databaseModule.getParkingSlot(vehicle.getLisencePlate()));
	}

	@Test
	void testRemoveVehicleFromParkingData() {
		databaseModule.addVehicleToSlot(vehicle);
		databaseModule.removeVehicleFromParkingData(vehicle.getParkingArea(), vehicle.getParkingSlot());
		assertEquals(false, databaseModule.getParkingData().get(vehicle.getParkingArea()).contains(vehicle));
	}

	@Test
	void testRemoveVehicleFromParkingLedger() {
		databaseModule.addVehicleToLedger(vehicle.getLisencePlate(), vehicle.getParkingArea(),
				vehicle.getParkingSlot());
		databaseModule.removeVehicleFromParkingLedger(vehicle.getLisencePlate());
		assertEquals(false, databaseModule.getParkingLedger().containsKey(vehicle.getLisencePlate()));
	}

}
