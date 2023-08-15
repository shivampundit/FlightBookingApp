package com.flightbookingapp.client;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import com.flightbookingapp.model.Flight;
import com.flightbookingapp.service.FlightBookingAppServiceImpl;
import com.flightbookingapp.service.IFlightBookingAppService;

public class Client {

	public static void main(String[] args) {

		IFlightBookingAppService appService = new FlightBookingAppServiceImpl();

		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("Flight Booking App Menu:");
			System.out.println("1. Display all flights");
			System.out.println("2. Search flights by location");
			System.out.println("3. Search flights by CompanyName");
			System.out.println("4. Search flights less than price");
			System.out.println("5. Search flights between date and time");
			System.out.println("6. Exit");
			System.out.print("Enter your choice: ");

			int choice = scanner.nextInt();
			scanner.nextLine(); // Consume the newline character

			switch (choice) {
			case 1:
				List<Flight> allFlights = appService.getAllFlights();
				displayFlights(allFlights);
				break;
			case 2:
				System.out.print("Enter from location: ");
				String fromLocation = scanner.nextLine();
				System.out.print("Enter to location: ");
				String toLocation = scanner.nextLine();
				List<Flight> locationFlights = appService.getFlightsByLocation(fromLocation, toLocation);
				displayFlights(locationFlights);
				break;
			case 3:
				System.out.print("Enter Comapany Name: ");
				String companyName = scanner.next();
				List<Flight> companyFlights = appService.getFlightsByCompany(companyName);
				displayFlights(companyFlights);
				break;
			case 4:
				System.out.print("Enter maximum price: ");
				double maxPrice = scanner.nextDouble();
				List<Flight> priceFlights = appService.getFlightsLessThanPrice(maxPrice);
				displayFlights(priceFlights);
				break;
			case 5:
				System.out.print("Enter start date and time (yyyy-MM-ddTHH:mm): ");
				LocalDateTime startDateTime = LocalDateTime.parse(scanner.nextLine());
				System.out.print("Enter end date and time (yyyy-MM-ddTHH:mm): ");
				LocalDateTime endDateTime = LocalDateTime.parse(scanner.nextLine());
				List<Flight> dateTimeFlights = appService.getFlightsBetweenDateTime(startDateTime, endDateTime);
				displayFlights(dateTimeFlights);
				break;
			case 6:
				System.out.println("Exiting the application.");
				return;
			default:
				System.out.println("Invalid choice. Please enter a valid option.");
			}
		}
	}

	private static void displayFlights(List<Flight> flights) {

		for (Flight flight : flights) {
			System.out.println(flight);
		}
	}
}
