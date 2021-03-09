package com.epam.parking.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Table(name = "parking_area")
@Entity
public class ParkingArea {

	@Id
	@Column(length=100)
	private String name;
	private boolean flag;

	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "parking_slots", joinColumns = @JoinColumn(name = "parking_area"))
	@Column(name = "slot")
	private List<SlotList> slots = new ArrayList<>();
	private int maxSlots;
	
	public ParkingArea() {
		
	}
	public ParkingArea(String name,int maxSlots) {
		this.name = name;
		this.maxSlots = maxSlots;
		this.flag = true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<SlotList> getSlots() {
		return slots;
	}

	public void setSlots(List<SlotList> slots) {
		this.slots = slots;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public int getMaxslots() {
		return maxSlots;
	}
	public void setMaxslots(int maxSlots) {
		this.maxSlots = maxSlots;
	}

}
