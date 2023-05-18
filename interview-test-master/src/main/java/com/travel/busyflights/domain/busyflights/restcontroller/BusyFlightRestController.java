package com.travel.busyflights.domain.busyflights.restcontroller;

import com.travel.busyflights.domain.busyflights.constants.ConstantUtils;
import com.travel.busyflights.domain.busyflights.request.BusyFlightsRequest;
import com.travel.busyflights.domain.busyflights.response.BusyFlightsResponse;
import com.travel.busyflights.domain.busyflights.service.BusyFlightInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/busyflightapis")
public class BusyFlightRestController {
    @Autowired
    BusyFlightInterface busyFlightInterface;

    public BusyFlightRestController(BusyFlightInterface busyFlightInterface) {
        this.busyFlightInterface = busyFlightInterface;
    }

    @GetMapping("/busyflights")
    public ResponseEntity<List<BusyFlightsResponse>> fetchBusyFlights(@RequestParam String from,@RequestParam String to,@RequestParam String departDate,@RequestParam String arrivalDate,@RequestParam int noOfpassenger) {
        BusyFlightsRequest busyFlightsRequest=new BusyFlightsRequest(from,to,departDate,arrivalDate,noOfpassenger);
        List<BusyFlightsResponse> busyFlightsResponse = busyFlightInterface.findByBusyFlight(busyFlightsRequest);
        if (busyFlightsResponse==null) {
            return new ResponseEntity<List<BusyFlightsResponse>>(HttpStatus.NO_CONTENT);
            // I many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<BusyFlightsResponse>>(busyFlightsResponse, HttpStatus.OK);
    }
}
