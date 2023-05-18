package com.travel.busyflights.domain.busyflights.service;

import com.travel.busyflights.domain.busyflights.request.BusyFlightsRequest;
import com.travel.busyflights.domain.busyflights.response.BusyFlightsResponse;

import java.util.List;

public interface BusyFlightInterface {
    List<BusyFlightsResponse> findByBusyFlight(BusyFlightsRequest busyFlightsRequest);
}
