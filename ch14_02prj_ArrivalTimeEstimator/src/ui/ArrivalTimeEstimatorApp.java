package ui;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class ArrivalTimeEstimatorApp {

	public static void main(String[] args) {
		System.out.println("Arrival Time Estimator");
		System.out.println();
		
		while (true) {
			//get departure date / time
			String dateString = 
					Console.getString("Departure date (YYYY-MM-DD): ");
			String timeString = 
					Console.getString("Departure time (HH:MM): ");
			String dateTimeString = dateString + "T" + timeString;
			LocalDateTime departureDateTime = LocalDateTime.parse(dateTimeString);
		
		// get miles / mph
			int miles = Console.getInt("Enter miles: ");
			int mph = Console.getInt("Enter miles per hour: ");
			System.out.println();
		
		//perform the calculations
			int hours = miles / mph;
			int minutes = miles % mph;
			LocalDateTime arrivalDateTime = departureDateTime
					.plusHours(hours)
					.plusMinutes(minutes);
			
		//display travel time and eta
		DateTimeFormatter date = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
		DateTimeFormatter time = DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM);
		System.out.println("Estimated travel time");
		System.out.println("Hours: "+hours);
		System.out.println("Minutes: "+minutes);
		System.out.println("Estimated date of arrival: "+date.format(arrivalDateTime));
		System.out.println("Estimated time of arrival "+time.format(arrivalDateTime));
		System.out.println();
		
		//ask if user wants to continue
		String result = Console.getString("Continue? (y/n): ");
		System.out.println();
		if (!result.equalsIgnoreCase("y")) {
			System.out.println("Bye!");
			break;
		}
		

		
		}
		

	}

}
