package business;

import java.time.LocalDate;

import util.Console;

public class ReservationCalcApp {

	public static void main(String[] args) {
		System.out.println("Reservation Calaculator \n");
		
		
		
		String choice = "y";
		
		while (choice.equalsIgnoreCase("y")) {
			
			int arrivalMonth = Console.getInt("Enter the arrival month (1-12): ", 0, 13);
			int arrivalDay = Console.getInt("Enter the arrival day (1-31): ", 0 , 32);
			int arrivalYear = Console.getInt("Enter the arrival year: ", 0, Integer.MAX_VALUE);
			
			int departureMonth = Console.getInt("Enter the departure month (1-12): ", 0, 13);
			int departureDay = Console.getInt("Enter the departure day (1-31): ", 0, 32);
			int departureYear = Console.getInt("Enter the departure year: ", 0, Integer.MAX_VALUE);
			
			LocalDate arrivalDate = LocalDate.of(arrivalYear, arrivalMonth, arrivalDay);
			LocalDate departureDate = LocalDate.of(departureYear, departureMonth, departureDay);
			
			Reservation res = new Reservation(arrivalDate, departureDate);
			
			System.out.println("Arrival Date: "+res.getArrivalDateFormatted());
			System.out.println("Departure Date: "+res.getDepartureDateFormatted());
			System.out.println("Price: "+res.getPricePerNightFormatted()+" per night.");
			System.out.println("Total Price: "+res.getTotalPriceFormatted()+ " for "+res.getNumberOfNights()+" nights.");
			
			choice = Console.getString("Continue? (y/n): ");
			System.out.println();
			
			
		}
		
		
		
		
		System.out.println("Bye!");

	}

}
