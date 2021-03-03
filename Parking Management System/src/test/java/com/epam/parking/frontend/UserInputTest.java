package com.epam.parking.frontend;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
@DisplayName ("License Plate Number Validation")
class UserInputTest {
	UserInput userInput;
	
	
	@Test
	void testUpperCase() {
		assertEquals(true, UserInput.checkValidLicensePlate("MP14MV2060"));
	}

	@Test
	void testLowerCase() {
		assertEquals(true, UserInput.checkValidLicensePlate("mp14mv2060"));
	}
	@Test
	void testWrongformat() {
		assertEquals(false, UserInput.checkValidLicensePlate("mpa4mv2060"));
	}
	
	@Test
	void testSmallNumber() {
		assertEquals(false, UserInput.checkValidLicensePlate("mp14mv20"));
	}
}
