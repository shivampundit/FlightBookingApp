package com.flightbookingapp.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import com.flightbookingapp.model.Flight;

public interface IFlightBookingAppService {

	void addFlight(Flight flight);

	void cancelFlight(int flightId);

	void updateFlightPrice(double price, int flightId);

	void updateFlightLocation(String fromLocation, String toLocation, int flightId);

	void changeFlightDateTime(LocalDateTime startDateTime, LocalDateTime endDateTime, int flightId);

	List<Flight> getAllFlights();

	List<Flight> getFlightsByCompany(String flightCompany);

	List<Flight> getFlightsByLocation(String fromLocation, String toLocation);

	List<Flight> getFlightsLessThanPrice(double maxPrice);

	List<Flight> getFlightsBetweenDateTime(LocalDateTime startDateTime, LocalDateTime endDateTime);

}
