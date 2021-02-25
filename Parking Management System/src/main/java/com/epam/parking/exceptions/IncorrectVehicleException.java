package com.epam.parking.exceptions;

public class IncorrectVehicleException extends Exception {
	final String errorMessage;
	public IncorrectVehicleException(String errorMessage) {
		this.errorMessage=errorMessage;
	}
	@Override
    public String toString(){
        return ("Error :"+errorMessage);
    }
}
