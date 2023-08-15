package com.flightbookingapp.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import com.flightbookingapp.dao.FlightBookingAppDaoImpl;
import com.flightbookingapp.dao.IFlightBookingAppDao;
import com.flightbookingapp.model.Flight;

public class FlightBookingAppServiceImpl implements IFlightBookingAppService {
	IFlightBookingAppDao appDao = new FlightBookingAppDaoImpl();

	@Override
	public void addFlight(Flight flight) {
		appDao.addFlight(flight);
		System.out.println("Flight Details Added Successfully!");
	}

	@Override
	public void cancelFlight(int flightId) {
		appDao.cancelFlight(flightId);
		System.out.println("Flight Cancelled Successfully!");

	}

	@Override
	public void updateFlightPrice(double price, int flightId) {
		appDao.updateFlightPrice(price, flightId);
		System.out.println("Flight Price Updated Successfully!");

	}

	@Override
	public void updateFlightLocation(String fromLocation, String toLocation, int flightId) {
		appDao.updateFlightLocation(fromLocation, toLocation, flightId);
		System.out.println("Flight Location Updated Successfully!");
	}

	@Override
	public void changeFlightDateTime(LocalDateTime startDateTime, LocalDateTime endDateTime, int flightId) {
		appDao.changeFlightDateTime(startDateTime, endDateTime, flightId);
		System.out.println("Flight Date Time Updated Successfully!");
	}

	@Override
	public List<Flight> getAllFlights() {
		return appDao.findAllFlights().stream().toList();
	}

	@Override
	public List<Flight> getFlightsByCompany(String flightCompany) {
		return appDao.findFlightsByCompany(flightCompany).stream().toList();
	}

	@Override
	public List<Flight> getFlightsByLocation(String fromLocation, String toLocation) {
		return appDao.findFlightsByLocation(fromLocation, toLocation).stream().toList();
	}

	@Override
	public List<Flight> getFlightsLessThanPrice(double maxPrice) {
		return appDao.findFlightsLessThanPrice(maxPrice).stream().toList();
	}

	@Override
	public List<Flight> getFlightsBetweenDateTime(LocalDateTime startDateTime, LocalDateTime endDateTime) {
		return appDao.findFlightsBetweenDateTime(startDateTime, endDateTime).stream().toList();
	}

}
