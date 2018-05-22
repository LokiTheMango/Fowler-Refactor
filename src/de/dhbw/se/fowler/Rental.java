package de.dhbw.se.fowler;

public class Rental {
	
    private Movie movie;
    private int daysRented;
    
    public Rental(final Movie newmovie, final int newdaysRented) {
        movie = newmovie;
        daysRented = newdaysRented;
    }
    
    public int getDaysRented() {
        return daysRented;
    }
    
    public Movie getMovie() {
        return movie;
    }
}
