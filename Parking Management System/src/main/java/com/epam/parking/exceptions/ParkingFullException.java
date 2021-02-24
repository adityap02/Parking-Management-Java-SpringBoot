package com.epam.parking.exceptions;

public class ParkingFullException extends Exception {
	String errorMessage;
	public ParkingFullException(String errorMessage) {
		this.errorMessage=errorMessage;
	}
	@Override
    public String toString(){
        return (errorMessage);
    }
}
