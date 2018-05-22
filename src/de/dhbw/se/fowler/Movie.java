package de.dhbw.se.fowler;

public class Movie {
	
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    private String title;
    private int priceCode;
    
    public Movie(final String title, final int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }
    
    public int getPriceCode() {
        return priceCode;
    }
    
    public void setPriceCode(final int pricecode) {
        this.priceCode = pricecode;
    }
    
    public String getTitle () {
        return title;
    }
    
}
