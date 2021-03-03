package com.epam.parking.services;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

import java.time.Instant;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.epam.parking.database.DatabaseModule;
import com.epam.parking.exceptions.DuplicateEntryException;
import com.epam.parking.exceptions.ParkingFullException;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(OrderAnnotation.class)

class ParkingServicesTest {

	PrintAllSlots printAllSlots = mock(PrintAllSlots.class);
	static DatabaseModule databaseModule;
	static AddNewParking addNewParking;
	static ParkVehicle parkVehicle;
	static UnparkVehicle unparkVehicle;
	static RandomParkingGenrator randomParkingGenrator;

	@BeforeAll
	public static void init() throws DuplicateEntryException {
		databaseModule = new DatabaseModule();
		addNewParking = new AddNewParking(databaseModule);
		parkVehicle = new ParkVehicle(databaseModule);
		unparkVehicle = new UnparkVehicle(databaseModule);
		randomParkingGenrator = new RandomParkingGenrator(databaseModule);
		
	}

	@DisplayName("Create New Parking Area Test")
	@Test
	@Order(1)
	void testCreateNewParking() {
		addNewParking.createNewParking("Test Parking Area", 1);
		assertEquals(true, databaseModule.getParkingData().containsKey("Test Parking Area"));
	}

	@DisplayName("Park a Vehicle Test")
	@Test
	@Order(2)
	void testParkVehicle() {
		parkVehicle.execute("MP14MV2060");
		assertEquals(true, databaseModule.getParkingLedger().containsKey("MP14MV2060"));

	}

	@DisplayName("Get Vehicle Intime Test")
	@Test
	@Order(3)
	void testIntime() {
		Instant instant = Instant.now();
		assertEquals(instant.getEpochSecond(), parkVehicle.getInTime());
	}

	@DisplayName("Unpark Vehicle Test")
	@Test
	@Order(4)
	void testUnparkVehicle() {
		unparkVehicle.execute("MP14MV2060");
		assertEquals(false, databaseModule.getParkingLedger().containsKey("mp14mv2060"));
	}

	@DisplayName("Unpark Non-Existent Vehicle Test")
	@Test
	@Order(5)
	void testUnparkNonExistentVehicle() {
		unparkVehicle.execute("MP14MV2061");
		assertEquals(false, databaseModule.getParkingLedger().containsKey("mp14mv2060"));
	}
	
	@DisplayName("Random Parking Generator")
	@Test
	@Order(6)
	void testGetNextEmptyParkingArea() {
		//parkVehicle.execute("MP14MV2060");
		assertDoesNotThrow(() -> {
			randomParkingGenrator.getNextEmptyParkingArea();
		});
	}

	@DisplayName("Random Parking Generator - Parking Full Case")
	@Test
	@Order(7)
	void testParkingAreaFull() {
		parkVehicle.execute("MP14MV2060");
		parkVehicle.execute("MP14MV2021");
		parkVehicle.execute("ab12cd1234");
		assertThrows(ParkingFullException.class,() -> {
			randomParkingGenrator.getNextEmptyParkingArea();
		});
	}
	@DisplayName("Random Parking Generator - Parking Full Case")
	@Test
	@Order(8)
	void testRandomParkingGenrator() {
		parkVehicle.execute("hf12ib9786");
		parkVehicle.execute("ab12cd8761");
		parkVehicle.execute("ac22ig7651");
		assertThrows(ParkingFullException.class,() -> {
			randomParkingGenrator.randomAreaGenrator();
		});
	}	
	@Test
	@Order(9)
	void testCreateDuplicateParking() {
		addNewParking.createNewParking("ABC Shopping Mall", 0);
	
	}

	@Test
	@Order(10)
	void testUnparkVehicle2() {
		printAllSlots.execute();
}



	

}
