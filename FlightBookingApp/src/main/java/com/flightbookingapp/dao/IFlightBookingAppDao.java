package com.flightbookingapp.dao;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import com.flightbookingapp.model.Flight;

public interface IFlightBookingAppDao {

	void addFlight(Flight flight);

	void cancelFlight(int flightId);

	void updateFlightPrice(double price, int flightId);

	void updateFlightLocation(String fromLocation, String toLocation, int flightId);

	void changeFlightDateTime(LocalDateTime startDateTime, LocalDateTime endDateTime, int flightId);

	List<Flight> findAllFlights();

	List<Flight> findFlightsByCompany(String flightCompany);

	List<Flight> findFlightsByLocation(String fromLocation, String toLocation);

	List<Flight> findFlightsLessThanPrice(double maxPrice);

	List<Flight> findFlightsBetweenDateTime(LocalDateTime startDateTime, LocalDateTime endDateTime);

}
