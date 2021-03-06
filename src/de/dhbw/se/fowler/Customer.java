package de.dhbw.se.fowler;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
	
    private String customername;
    private Vector<Rental> rentals = new Vector<Rental>();
    
    public Customer (final String customername) {
    	this.customername = customername;
    }
    
    public void addRental(final Rental rental) {
        rentals.addElement(rental);
    }
    
    public String getCustomername () {
        return customername;
    }
    
    public String statement() {
        int frequentRenterPoints = 0;
        Enumeration<Rental> enum_rentals = rentals.elements();	    
        String result = "Rental Record for " + this.getCustomername() + "\n";
        result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

        while (enum_rentals.hasMoreElements()) {
            Rental each = enum_rentals.nextElement();

            // add frequent renter points
            frequentRenterPoints += each.getFrequentRenterPoints();
            //show figures for this rental
            result += "\t" + each.getMovie().getTitle()+ "\t" + "\t" + each.getDaysRented() + "\t" + String.valueOf(each.getCharge()) + "\n";
        }
        //add footer lines
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return result;
    }

	private double getTotalCharge() {
    	double result = 0;
    	Enumeration<Rental> enum_rentals = rentals.elements();
        while (enum_rentals.hasMoreElements()) {
            Rental each = enum_rentals.nextElement();
            result += each.getCharge();
        }
        return result;
    }

}
    