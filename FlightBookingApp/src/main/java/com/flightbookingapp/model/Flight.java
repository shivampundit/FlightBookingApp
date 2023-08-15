package com.flightbookingapp.model;

import java.time.LocalDateTime;

public class Flight {
	private Integer flightId;
	private String companyName;
	private String fromLocation;
	private String toLocation;
	private double price;
	private LocalDateTime dapartureDateTime;
	private LocalDateTime arrivalDateTime;
	private int seats;

	public Flight() {
		super();
	}

	public Flight(int flightId, String companyName, String fromLocation, String toLocation, double price,
			LocalDateTime dapartureDateTime, LocalDateTime arrivalDateTime, Integer seats) {
		super();
		this.flightId = flightId;
		this.companyName = companyName;
		this.fromLocation = fromLocation;
		this.toLocation = toLocation;
		this.price = price;
		this.dapartureDateTime = dapartureDateTime;
		this.arrivalDateTime = arrivalDateTime;
		this.seats = seats;
	}

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getFromLocation() {
		return fromLocation;
	}

	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}

	public String getToLocation() {
		return toLocation;
	}

	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDateTime getDapartureDateTime() {
		return dapartureDateTime;
	}

	public void setDapartureDateTime(LocalDateTime dapartureDateTime) {
		this.dapartureDateTime = dapartureDateTime;
	}

	public LocalDateTime getArrivalDateTime() {
		return arrivalDateTime;
	}

	public void setArrivalDateTime(LocalDateTime arrivalDateTime) {
		this.arrivalDateTime = arrivalDateTime;
	}

	public Integer getSeats() {
		return seats;
	}

	public void setSeats(Integer seats) {
		this.seats = seats;
	}

	@Override
	public String toString() {
		return "Flight [flightId=" + flightId + ", companyName=" + companyName + ", fromLocation=" + fromLocation
				+ ", toLocation=" + toLocation + ", price=" + price + ", dapartureDateTime=" + dapartureDateTime
				+ ", arrivalDateTime=" + arrivalDateTime + ", seats=" + seats + "]";
	}

}
