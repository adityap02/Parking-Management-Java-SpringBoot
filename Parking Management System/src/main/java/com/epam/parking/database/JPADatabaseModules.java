package com.epam.parking.database;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.epam.parking.entity.ParkingArea;
import com.epam.parking.entity.ParkingBook;
import com.epam.parking.entity.SlotList;
import com.epam.parking.entity.Vehicle;
import com.epam.parking.exceptions.ParkingFullException;

public class JPADatabaseModules implements DBModules {
	EntityManagerFactory eFactory = Persistence.createEntityManagerFactory("my-local-db");
	EntityManager entityManager = eFactory.createEntityManager();
	DBOperations dbo= new JPAImplementation() ;
	
	@Override
	public ParkingArea addNewParkingArea(String parkingName, int numberOfParkingSlots) {

		ParkingArea pArea = new ParkingArea(parkingName, numberOfParkingSlots);
		pArea.setSlots(createEmptySlotList(numberOfParkingSlots));
		dbo.insert(entityManager, pArea);
		return pArea;

	}

	@Override
	public boolean isVehicleAlreadyParked(String licensePlateNumber) {
		Vehicle v = entityManager.find(Vehicle.class, licensePlateNumber);
		boolean result = true;
		if (v == null)
			result = false;
		return result;
	}

	@Override
	public ParkingArea getParkingAreaObject(String parkingArea) {
		ParkingArea pArea = null;
		pArea = entityManager.find(ParkingArea.class, parkingArea);
		return pArea;
	}

	@Override
	public List<ParkingArea> getParkingAreaObjectList() {
		List<ParkingArea> pAreaList;
		pAreaList = entityManager.createQuery("from ParkingArea where flag=1").getResultList();
		return pAreaList;
	}

	@Override
	public void addVehicleToSlot(Vehicle v) {
		dbo.insert(entityManager, v);
	}

	@Override
	public Vehicle getVehicleObject(String licensePlateNumber) {
		return entityManager.find(Vehicle.class, licensePlateNumber);
	}

	@Override
	public void updateParkingArea(String parkingArea, int slot, String licensePlateNumber) {
		ParkingArea pArea = entityManager.find(ParkingArea.class, parkingArea);
		List<SlotList> sList = pArea.getSlots();
		for (SlotList s : sList) {
			if (s.getSlotNumber() == slot) {
				s.setSlotStatus(licensePlateNumber);
				break;
			}
		}
		pArea.setSlots(sList);
		dbo.insert(entityManager, pArea);
	}

	@Override
	public void removeVehicle(String licensePlateNumber) {
		dbo.delete(entityManager, entityManager.find(Vehicle.class, licensePlateNumber));
	}

	@Override
	public void addLogToParkingBook(Vehicle v) {
		ParkingBook pBook = new ParkingBook(v);
		dbo.insert(entityManager, pBook);
	}

	public List<SlotList> createEmptySlotList(int numberOfParkingSlots) {
		List<SlotList> sList = new ArrayList<>();
		for (int i = 1; i <= numberOfParkingSlots; i++) {
			sList.add(new SlotList(i, "empty"));
		}
		return sList;
	}

	@Override
	public ParkingArea getRandomParkingArea() throws ParkingFullException {
		ParkingArea pArea = (ParkingArea) entityManager.createQuery("from ParkingArea p ORDER BY RAND()")
				.getResultList().get(0);
		if (pArea == null)
			throw new ParkingFullException("No Parking Areas Available");
		return pArea;
	}

	@Override
	public String getParkingArea(String licensePlateNumber) {
		return null;
	}

	@Override
	public int getParkingSlot(String licensePlateNumber) {
		return 0;
	}

	@Override
	public Vehicle getParkedVehicle(String licensePlateNumber) {
		return entityManager.find(Vehicle.class, licensePlateNumber);

	}
}
