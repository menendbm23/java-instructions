package ui;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;

public class LocalDateTimeApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the date time app!!");
		
		//p.443
		LocalDate currentDate = LocalDate.now();
			System.out.println(currentDate);
		LocalTime currentTime = LocalTime.now();
			System.out.println(currentTime);
		LocalDateTime currentDateTime = LocalDateTime.now();
			System.out.println(currentDateTime);
			
		//rest of examples are focusing on LocalDate
		LocalDate stPattys = LocalDate.of(2021, 3, 17);
		LocalDate julyFourth = LocalDate.parse("2021-07-04");
		
		System.out.println(stPattys);
		System.out.println(julyFourth);
		
		System.out.println("Using today as an example:");
		System.out.println(" getYear = "+currentDate.getYear());
		System.out.println(" getMonth = "+currentDate.getMonth());
		System.out.println(" getMonthValue = "+currentDate.getMonthValue());
		System.out.println(" getDayOfMonth = "+currentDate.getDayOfMonth());
		System.out.println(" getDayOfYear = "+currentDate.getDayOfYear());
		System.out.println(" getDayOfWeek = "+currentDate.getDayOfWeek());
		
		
		//compare today to St. Patty's Day
		System.out.println("Is today before St. Pattys? "+currentDate.isBefore(stPattys));
		System.out.println("Is today after St. Pattys? "+currentDate.isAfter(stPattys));
		System.out.println("Compare today before St. Pattys? "+currentDate.compareTo(stPattys));

		//p. 448
		LocalDate weekFromNow = currentDate.withDayOfMonth(2).withMonth(3);
		System.out.println(weekFromNow);
		
		//p. 451
		LocalDate twoWeeksFromNow = currentDate.plus(2, ChronoUnit.WEEKS);
		System.out.println(twoWeeksFromNow);
		
		LocalDate oneYearFromNow = currentDate.plusYears(1);
		System.out.println(oneYearFromNow);
		
		long days = currentDate.until(stPattys, ChronoUnit.DAYS);
		System.out.println(days + " days until St Pattys!");
		
		days = ChronoUnit.DAYS.between(stPattys, julyFourth);
		System.out.println(days + " days between st pattys and july 4th");
		
		
		//p. 453
		DateTimeFormatter sdf = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
		DateTimeFormatter mdf = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
		DateTimeFormatter ldf = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
		DateTimeFormatter fdf = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);

		System.out.println("Today, short format: "+sdf.format(currentDate));
		System.out.println("Today, medium format: "+mdf.format(currentDate));
		System.out.println("Today, long format: "+ldf.format(currentDate));
		System.out.println("Today, full format: "+fdf.format(currentDate));

		
		
		
		
		
		
		
		
		
			
		
		System.out.println("Bye!");

	}

}
