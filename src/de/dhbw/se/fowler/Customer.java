package de.dhbw.se.fowler;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
	
    private String customername;
    private Vector rentals = new Vector();
    
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
        Enumeration enum_rentals = rentals.elements();	    
        String result = "Rental Record for " + this.getCustomername() + "\n";
        result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

        while (enum_rentals.hasMoreElements()) {
            Rental each = (Rental) enum_rentals.nextElement();

            // add frequent renter points
            frequentRenterPoints += getFrequentRenterPoints(each);
            //show figures for this rental
            result += "\t" + each.getMovie().getTitle()+ "\t" + "\t" + each.getDaysRented() + "\t" + String.valueOf(each.getCharge()) + "\n";
        }
        //add footer lines
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return result;
    }
    
    private int getFrequentRenterPoints(final Rental each) {
    	// add bonus for a two day new release rental
    	if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1)
    		return 2;
    	return 1;
	}

	private double getTotalCharge() {
    	double result = 0;
    	Enumeration enum_rentals = rentals.elements();
        while (enum_rentals.hasMoreElements()) {
            Rental each = (Rental) enum_rentals.nextElement();
            result += each.getCharge();
        }
        return result;
    }

}
    