package com.epam.parking.entity;

import javax.persistence.Embeddable;

@Embeddable
public class SlotList {

	private int slotNumber;
	private String slotStatus;

	public SlotList() {
	}

	public SlotList(int slotNumber, String slotStatus) {
		super();
		this.slotNumber = slotNumber;
		this.slotStatus = slotStatus;
	}

	public int getSlotNumber() {
		return slotNumber;
	}

	public void setSlotNumber(int slotNumber) {
		this.slotNumber = slotNumber;
	}

	public String getSlotStatus() {
		return slotStatus;
	}

	public void setSlotStatus(String slotStatus) {
		this.slotStatus = slotStatus;
	}

}
