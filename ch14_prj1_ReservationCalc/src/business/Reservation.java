package business;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;

import javax.swing.text.DateFormatter;

public class Reservation {
	private static final double NIGHTLY_RATE = 145.0;
	private LocalDate arrivalDate;
	private LocalDate departureDate;
	private DateTimeFormatter dateFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
	private NumberFormat currency = NumberFormat.getCurrencyInstance();
	
	public Reservation(LocalDate arrivalDate, LocalDate departureDate) {
		super();
		this.arrivalDate = arrivalDate;
		this.departureDate = departureDate;
	}
	
	public LocalDate getArrivalDate() {
		return arrivalDate;
	}
	
	public String getArrivalDateFormatted() {
        return dateFormatter.format(arrivalDate);
    } 
	
	public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }
	
	public LocalDate getDepartureDate() {
		return departureDate;
	}
	
	public String getDepartureDateFormatted() {
        return dateFormatter.format(departureDate);
    } 
	
	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}
	
	public int getNumberOfNights() {
		// use between method (p.451)
		long nbrNights = ChronoUnit.DAYS.between(arrivalDate, departureDate);
		return (int)nbrNights;
	}
	
	public String getPricePerNightFormatted() {
		return currency.format(NIGHTLY_RATE);
	}
	
	public double getTotalPrice() {
		return getNumberOfNights() * NIGHTLY_RATE;
	}
	
	public String getTotalPriceFormatted() {
		return currency.format(getTotalPrice());
	}
	
	
	
	
}