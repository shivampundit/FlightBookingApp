package com.flightbookingapp.client;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import com.flightbookingapp.model.Flight;
import com.flightbookingapp.service.FlightBookingAppServiceImpl;
import com.flightbookingapp.service.IFlightBookingAppService;

public class Admin {

	public static void main(String[] args) {

		IFlightBookingAppService appService = new FlightBookingAppServiceImpl();

		Scanner scanner = new Scanner(System.in);
		Integer flightId;
		String companyName;
		String fromLocation = null;
		String toLocation = null;
		double price = 0;
		LocalDateTime dapartureDateTime;
		LocalDateTime arrivalDateTime;
		int seats;
		while (true) {
			System.out.println("Flight Booking App Menu:");
			System.out.println("1. Add Flights");
			System.out.println("2. Cancel Flight");
			System.out.println("3. Update Flight Location");
			System.out.println("4. Update Flight Price");
			System.out.println("5. Change Flight DateTime");
			System.out.println("6. Exit");
			System.out.print("Enter your choice: ");

			int choice = scanner.nextInt();
			scanner.nextLine(); // Consume the newline character

			switch (choice) {
			case 1:
				System.out.println("Enter Flight Id:");
				flightId = scanner.nextInt();
				System.out.println("Enter Flight Comapany Name:");
				companyName = scanner.next();
				System.out.println("Enter From Location:");
				fromLocation = scanner.next();
				System.out.println("Enter to Location:");
				toLocation = scanner.next();
				System.out.println("Enter Flight price:");
				price = scanner.nextDouble();
				System.out.println("Enter Deaprture Year:(4 digit)");
				int dyear = scanner.nextInt();
				System.out.println("Enter Departure Month:(2 digit)");
				int dmonth = scanner.nextInt();
				System.out.println("Enter Departure date:(2 digit)");
				int ddate = scanner.nextInt();
				System.out.println("Enter Departure Hour:(2 digit)");
				int dhour = scanner.nextInt();
				System.out.println("Enter Departure Minute:(2 digit)");
				int dminute = scanner.nextInt();
				System.out.println("Enter Arrival Year:(4 digit)");
				int ayear = scanner.nextInt();
				System.out.println("Enter Arrival Month:(2 digit)");
				int amonth = scanner.nextInt();
				System.out.println("Enter Arrival date:(2 digit)");
				int adate = scanner.nextInt();
				System.out.println("Enter Arrival Hour:(2 digit)");
				int ahour = scanner.nextInt();
				System.out.println("Enter Arrival Minute:(2 digit)");
				int aminute = scanner.nextInt();
				System.out.println("Enter no of seats:");
				seats = scanner.nextInt();
				Flight flight = new Flight(flightId, companyName, fromLocation, toLocation, price,
						LocalDateTime.of(dyear, dmonth, ddate, dhour, dminute),
						LocalDateTime.of(ayear, amonth, adate, ahour, aminute), seats);

				appService.addFlight(flight);
				break;
			case 2:
				System.out.println("Enter Flight Id:");
				int fligtId = scanner.nextInt();
				appService.cancelFlight(fligtId);
				break;
			case 3:
				System.out.println("Enter Flight Id:");
				fligtId = scanner.nextInt();
				System.out.println("Enter new Flight fromLocation:");
				fromLocation = scanner.next();
				System.out.println("Enter new Flight toLocation:");
				toLocation = scanner.next();
				appService.updateFlightLocation(fromLocation, toLocation, fligtId);
				break;
			case 4:
				System.out.println("Enter Flight Id:");
				fligtId = scanner.nextInt();
				System.out.println("Enter new Price:");
				price = scanner.nextDouble();
				appService.updateFlightPrice(price, fligtId);
				break;
			case 5:
//				System.out.println("Enter Flight Id:");
//				fligtId = scanner.nextInt();
//				System.out.print("Enter start date and time (yyyy-MM-ddTHH:mm): ");
//				LocalDateTime startDateTime = LocalDateTime.parse(scanner.next());
//				System.out.print("Enter end date and time (yyyy-MM-ddTHH:mm): ");
//				LocalDateTime endDateTime = LocalDateTime.parse(scanner.next());
				System.out.println("Enter Flight Id:");
				flightId = scanner.nextInt();
				System.out.println("Enter Deaprture Year:(4 digit)");
				dyear = scanner.nextInt();
				System.out.println("Enter Departure Month:(2 digit)");
				dmonth = scanner.nextInt();
				System.out.println("Enter Departure date:(2 digit)");
				ddate = scanner.nextInt();
				System.out.println("Enter Departure Hour:(2 digit)");
				dhour = scanner.nextInt();
				System.out.println("Enter Departure Minute:(2 digit)");
				dminute = scanner.nextInt();
				System.out.println("Enter Arrival Year:(4 digit)");
				ayear = scanner.nextInt();
				System.out.println("Enter Arrival Month:(2 digit)");
				amonth = scanner.nextInt();
				System.out.println("Enter Arrival date:(2 digit)");
				adate = scanner.nextInt();
				System.out.println("Enter Arrival Hour:(2 digit)");
				ahour = scanner.nextInt();
				System.out.println("Enter Arrival Minute:(2 digit)");
				aminute = scanner.nextInt();
				appService.changeFlightDateTime(LocalDateTime.of(dyear, dmonth, ddate, dhour, dminute),
						LocalDateTime.of(ayear, amonth, adate, ahour, aminute), flightId);
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
