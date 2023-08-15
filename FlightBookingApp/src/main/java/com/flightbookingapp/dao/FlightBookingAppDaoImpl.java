package com.flightbookingapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.flightbookingapp.model.Flight;
import com.flightbookingapp.util.BookFlightQueries;
import com.flightbookingapp.util.DBConnection;

public class FlightBookingAppDaoImpl implements IFlightBookingAppDao {

	@Override
	public void addFlight(Flight flight) {
		try (Connection connection = DBConnection.openConnection(); // get connection
				PreparedStatement statement = connection.prepareStatement(BookFlightQueries.INSERT_NEW_FLIGHT)) {
			statement.setInt(1, flight.getFlightId());
			statement.setString(2, flight.getCompanyName());
			statement.setString(3, flight.getFromLocation());
			statement.setString(4, flight.getToLocation());
			statement.setDouble(5, flight.getPrice());
			statement.setTimestamp(6, Timestamp.valueOf(flight.getDapartureDateTime()));
			statement.setTimestamp(7, Timestamp.valueOf(flight.getArrivalDateTime()));
			statement.setInt(8, flight.getSeats());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void cancelFlight(int flightId) {
		try (Connection connection = DBConnection.openConnection(); // get connection
				PreparedStatement statement = connection.prepareStatement(BookFlightQueries.DELETE_FLIGHT)) {
			statement.setInt(1, flightId);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateFlightPrice(double price, int flightId) {
		try (Connection connection = DBConnection.openConnection(); // get connection
				PreparedStatement statement = connection.prepareStatement(BookFlightQueries.UPDATE_FLIGHT_PRICE)) {
			statement.setDouble(1, price);
			statement.setInt(2, flightId);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateFlightLocation(String fromLocation, String toLocation, int flightId) {
		try (Connection connection = DBConnection.openConnection(); // get connection
				PreparedStatement statement = connection.prepareStatement(BookFlightQueries.UPDATE_FLIGHT_LOCATIONS)) {
			statement.setString(1, fromLocation);
			statement.setString(2, toLocation);
			statement.setInt(3, flightId);

			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void changeFlightDateTime(LocalDateTime startDateTime, LocalDateTime endDateTime, int flightId) {
		try (Connection connection = DBConnection.openConnection(); // get connection
				PreparedStatement statement = connection.prepareStatement(BookFlightQueries.UPDATE_FLIGHT_DATE_TIME)) {
			statement.setObject(1, startDateTime);
			statement.setObject(2, endDateTime);
			statement.setInt(3, flightId);

			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Flight> findAllFlights() {
		List<Flight> flights = new ArrayList<>();
		try (Connection connection = DBConnection.openConnection(); // get connection
				PreparedStatement statement = connection.prepareStatement(BookFlightQueries.SELECT_ALL_FLIGHTS)) {
			try (ResultSet resultSet = statement.executeQuery()) {
				while (resultSet.next()) {
					Flight flight = createFlightFromResultSet(resultSet);
					flights.add(flight);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flights;
	}

	@Override
	public List<Flight> findFlightsByCompany(String flightCompany) {
		List<Flight> flights = new ArrayList<>();
		try (Connection connection = DBConnection.openConnection(); // get connection
				PreparedStatement statement = connection
						.prepareStatement(BookFlightQueries.SELECT_FLIGHTS_BY_COMPANY)) {
			statement.setString(1, flightCompany);
			try (ResultSet resultSet = statement.executeQuery()) {
				while (resultSet.next()) {
					Flight flight = createFlightFromResultSet(resultSet);
					flights.add(flight);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flights;
	}

	@Override
	public List<Flight> findFlightsByLocation(String fromLocation, String toLocation) {
		List<Flight> flights = new ArrayList<>();
		try (Connection connection = DBConnection.openConnection(); // get connection
				PreparedStatement statement = connection
						.prepareStatement(BookFlightQueries.SELECT_FLIGHTS_BY_LOCATION)) {
			statement.setString(1, fromLocation);
			statement.setString(2, toLocation);
			try (ResultSet resultSet = statement.executeQuery()) {
				while (resultSet.next()) {
					Flight flight = createFlightFromResultSet(resultSet);
					flights.add(flight);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flights;
	}

	@Override
	public List<Flight> findFlightsLessThanPrice(double maxPrice) {
		List<Flight> flights = new ArrayList<>();
		try (Connection connection = DBConnection.openConnection(); // get connection
				PreparedStatement statement = connection
						.prepareStatement(BookFlightQueries.SELECT_FLIGHTS_LESS_THAN_PRICE)) {
			statement.setDouble(1, maxPrice);
			try (ResultSet resultSet = statement.executeQuery()) {
				while (resultSet.next()) {
					Flight flight = createFlightFromResultSet(resultSet);
					flights.add(flight);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flights;
	}

	@Override
	public List<Flight> findFlightsBetweenDateTime(LocalDateTime startDateTime, LocalDateTime endDateTime) {
		List<Flight> flights = new ArrayList<>();
		try (Connection connection = DBConnection.openConnection(); // get connection
				PreparedStatement statement = connection
						.prepareStatement(BookFlightQueries.SELECT_FLIGHTS_BETWEEN_DATETIME)) {
			statement.setObject(1, startDateTime);
			statement.setObject(2, endDateTime);
			try (ResultSet resultSet = statement.executeQuery()) {
				while (resultSet.next()) {
					Flight flight = createFlightFromResultSet(resultSet);
					flights.add(flight);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flights;
	}

	private Flight createFlightFromResultSet(ResultSet resultSet) throws SQLException {
		int flightId = resultSet.getInt("flightId");
		String flightName = resultSet.getString("companyName");
		String fromLocation = resultSet.getString("fromLocation");
		String toLocation = resultSet.getString("toLocation");
		double price = resultSet.getDouble("price");
		LocalDateTime dapartureDateTime = resultSet.getTimestamp("dapartureDateTime").toLocalDateTime();
		LocalDateTime arrivalDateTime = resultSet.getTimestamp("arrivalDateTime").toLocalDateTime();
		int seats = resultSet.getInt("seats");

		return new Flight(flightId, flightName, fromLocation, toLocation, price, dapartureDateTime, arrivalDateTime,
				seats);
	}

}
