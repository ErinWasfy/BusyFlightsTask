package com.travel.busyflights.domain.busyflights.request;


import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Size;

public class BusyFlightsRequest {

    @Size(min=3,max=3)
    private String origin;
    @Size(min=3,max=3)
    private String destination;
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    private String departureDate;
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    private String returnDate;
    @Size(min=1,max=4,message = "Number of passengers must be between one and four")
    private int numberOfPassengers;

    public String getOrigin(String lhr) {
        return origin;
    }

    public void setOrigin(final String origin) {
        this.origin = origin;
    }

    public BusyFlightsRequest(String origin, String destination, String departureDate, String returnDate, int numberOfPassengers) {
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.numberOfPassengers = numberOfPassengers;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(final String destination) {
        this.destination = destination;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(final String departureDate) {
        this.departureDate = departureDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(final String returnDate) {
        this.returnDate = returnDate;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(final int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }
}
