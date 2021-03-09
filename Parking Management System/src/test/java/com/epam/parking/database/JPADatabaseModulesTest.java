package com.epam.parking.database;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.service.spi.InjectService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import com.epam.parking.entity.ParkingArea;

@ExtendWith(MockitoExtension.class)
class JPADatabaseModulesTest {
	@Mock
	JPAImplementation dbo;
	@Mock
	EntityManager entityManager;

	@InjectMocks
	JPADatabaseModules dbm;

	//ParkingArea parkingArea;
	
	@BeforeEach
	void setup() {
		MockitoAnnotations.initMocks(this);
	//	parkingArea = new ParkingArea("aditya", 10);
	}

	@Test
	void addNewParkingTest() {
		
	}

}
