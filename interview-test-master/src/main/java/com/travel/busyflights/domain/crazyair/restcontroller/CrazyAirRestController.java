package com.travel.busyflights.domain.crazyair.restcontroller;

import com.travel.busyflights.domain.crazyair.request.CrazyAirRequest;
import com.travel.busyflights.domain.crazyair.response.CrazyAirResponse;
import com.travel.busyflights.domain.crazyair.service.CrazyAirInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/crazyairsapis")
public class CrazyAirRestController {
       @Autowired
       CrazyAirInterface crazyAirInterface;

    public CrazyAirRestController(CrazyAirInterface crazyAirInterface) {
        this.crazyAirInterface = crazyAirInterface;
    }

    @GetMapping("/crazyairflights")
        public ResponseEntity<List<CrazyAirResponse>> fetchCrazyAirFlights(CrazyAirRequest crazyAirRequest) {
            List<CrazyAirResponse> crazyAirResponse = crazyAirInterface.findByCrazyAir(crazyAirRequest);
            if (crazyAirResponse==null) {
                return new ResponseEntity<List<CrazyAirResponse>>(HttpStatus.NO_CONTENT);
                // I many decide to return HttpStatus.NOT_FOUND
            }
            return new ResponseEntity<List<CrazyAirResponse>>(crazyAirResponse, HttpStatus.OK);
        }
}
