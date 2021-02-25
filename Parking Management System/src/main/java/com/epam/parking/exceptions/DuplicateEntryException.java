package com.epam.parking.exceptions;

public class DuplicateEntryException extends Exception {
	final String errorMessage;
	public DuplicateEntryException(String errorMessage) {
		this.errorMessage=errorMessage;
	}
	@Override
    public String toString(){
        return ("Entry Already Exists :"+errorMessage);
    }
}
