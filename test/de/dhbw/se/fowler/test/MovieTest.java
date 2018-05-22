package de.dhbw.se.fowler.test;
import org.junit.Before;
import org.junit.Test;

import de.dhbw.se.fowler.Movie;

import static org.junit.Assert.*;

public class MovieTest {

    private Movie movie;

    @Before
    public void setUp() {
        movie = new Movie("movie", 0);
    }

    @Test
    public void testConstructor() {
        assertEquals("movie", movie.getTitle());
        assertEquals(0, movie.getPriceCode());
    }

    @Test
    public void testSetPriceCode() {
        movie.setPriceCode(1);

        assertEquals(1, movie.getPriceCode());
    }
}
