package com.flightbookingapp.util;

public class BookFlightQueries {
	public static final String CREATE_QUERY = "CREATE TABLE flights (flightId INTEGER PRIMARY KEY, companyName VARCHAR(30), fromLocation VARCHAR(30), toLocation VARCHAR(30), price double ,dapartureDateTime DATETIME, arrivalDateTime DATETIME, seats INT)";
	public static final String INSERT_NEW_FLIGHT = "INSERT INTO flights VALUES (?,?,?,?,?,?,?,?)";
	public static final String DELETE_FLIGHT = "DELETE FROM flights WHERE flightId = ?";
	public static final String UPDATE_FLIGHT_PRICE = "UPDATE flights SET price = ? WHERE flightId = ?";
	public static final String UPDATE_FLIGHT_LOCATIONS = "UPDATE flights SET fromLocation = ?, toLocation = ? WHERE flightId = ?";
	public static final String UPDATE_FLIGHT_DATE_TIME = "UPDATE flights SET dapartureDateTime = ?, arrivalDateTime = ? WHERE flightId = ?";
	public static final String SELECT_ALL_FLIGHTS = "SELECT * FROM flights";
	public static final String SELECT_FLIGHTS_BY_COMPANY = "SELECT * FROM flights where companyName = ?";
	public static final String SELECT_FLIGHTS_BY_LOCATION = "SELECT * FROM flights WHERE fromLocation = ? AND toLocation = ?";
	public static final String SELECT_FLIGHTS_LESS_THAN_PRICE = "SELECT * FROM flights WHERE price < ?";
	public static final String SELECT_FLIGHTS_BETWEEN_DATETIME = "SELECT * FROM flights WHERE dapartureDateTime BETWEEN ? AND ?";
	public static final String ALTER_COLUMN = "ALTER TABLE flights MODIFY COLUMN price double";
}
