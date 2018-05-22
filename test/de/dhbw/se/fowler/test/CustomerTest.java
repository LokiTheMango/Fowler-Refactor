package de.dhbw.se.fowler.test;

import org.junit.Before;
import org.junit.Test;

import de.dhbw.se.fowler.Customer;
import de.dhbw.se.fowler.Movie;
import de.dhbw.se.fowler.Rental;

import static org.junit.Assert.*;

public class CustomerTest {
	
    private Customer customer;

    @Before
    public void setUp() {
        customer = new Customer("customer");
    }

    @Test
    public void testName() {
        assertEquals("customer", customer.getCustomername());
    }

    @Test
    public void testEmptyStatement() {
        assertEquals("Rental Record for customer\n" +
                "\tTitle\t\tDays\tAmount\n" +
                "Amount owed is 0.0\n" +
                "You earned 0 frequent renter points", customer.statement());
    }

    @Test
    public void testStatement() {
        Movie movie = new Movie("movie", 1);
        Rental rental = new Rental(movie, 1);
        customer.addRental(rental);

        assertEquals("Rental Record for customer\n" +
                "\tTitle\t\tDays\tAmount\n" +
                "\tmovie\t\t1\t3.0\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter points", customer.statement());
    }
}
