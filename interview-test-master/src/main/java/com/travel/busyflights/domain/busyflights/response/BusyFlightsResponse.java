package com.travel.busyflights.domain.busyflights.response;


import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Size;

public class BusyFlightsResponse {
   private String airline;
    @DecimalMax(value = "0.00")
    private double fare;
    @Size(min=3,max=3)
    private String departureAirportCode;
    @Size(min=3,max=3)
    private String destinationAirportCode;
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    private String departureDate;
   @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    private String arrivalDate;


    public BusyFlightsResponse() {
    }

    public BusyFlightsResponse(String airline, double fare, String departureAirportCode, String destinationAirportCode, String departureDate, String arrivalDate) {
        this.airline = airline;
        this.fare = fare;
        this.departureAirportCode = departureAirportCode;
        this.destinationAirportCode = destinationAirportCode;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
    }

    public String getAirline() {
        return airline;
    }

    public double getFare() {
        return fare;
    }

    public String getDepartureAirportCode() {
        return departureAirportCode;
    }

    public String getDestinationAirportCode() {
        return destinationAirportCode;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }
}
