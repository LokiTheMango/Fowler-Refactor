package de.dhbw.se.fowler.test;

import org.junit.Before;
import org.junit.Test;

import de.dhbw.se.fowler.Movie;
import de.dhbw.se.fowler.Rental;

import static org.junit.Assert.*;

public class RentalTest {
	
    private Movie movie;
    private Rental rental;

    @Before
    public void setUp() {
        movie = new Movie("movie", 5);
        rental = new Rental(movie, 5);
    }

    @Test
    public void testConstructor() {
        assertEquals(5, rental.getDaysRented());
        assertEquals(movie, rental.getMovie());
    }
}