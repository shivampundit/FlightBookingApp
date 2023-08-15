package com.flightbookingapp.exceptions;

public class FlightNotFoundException extends RuntimeException {

	public FlightNotFoundException() {
		super();
	}

	public FlightNotFoundException(String message) {
		super(message);
	}

}
