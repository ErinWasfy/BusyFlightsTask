package com.travel.busyflights.domain.busyflights.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.travel.busyflights.domain.busyflights.constants.ConstantUtils;
import com.travel.busyflights.domain.busyflights.request.BusyFlightsRequest;
import com.travel.busyflights.domain.busyflights.response.BusyFlightsResponse;
import com.travel.busyflights.domain.crazyair.response.CrazyAirResponse;
import com.travel.busyflights.domain.toughjet.response.ToughJetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.WebClientAutoConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class BusyFlightService implements BusyFlightInterface {

    RestTemplate restTemplate;
    JsonNode jsonNodeForToughJet,jsonNodeForCrazyAir;


    @Override
    public List<BusyFlightsResponse> findByBusyFlight(BusyFlightsRequest busyFlightsRequest) {
        restTemplate=new RestTemplate();
        if(busyFlightsRequest!=null) {
            jsonNodeForToughJet = restTemplate.getForObject(ConstantUtils.TOUGHJET.getUrl(), JsonNode.class);
            jsonNodeForCrazyAir = restTemplate.getForObject(ConstantUtils.CRAZYAIRJET.getUrl(), JsonNode.class);
            double totalPrice = (jsonNodeForToughJet.get("basePrice").asDouble() + jsonNodeForToughJet.get("tax").asDouble() - (jsonNodeForToughJet.get("basePrice").asDouble() + jsonNodeForToughJet.get("tax").asDouble()) * jsonNodeForToughJet.get("discount").asDouble() / 100);
            return Arrays.asList(new BusyFlightsResponse(jsonNodeForCrazyAir.get("airline").asText(), totalPrice, jsonNodeForCrazyAir.get("departureAirportcode").asText(), jsonNodeForCrazyAir.get("destinationAirportcode").asText(), jsonNodeForCrazyAir.get("departureDate").asText(), jsonNodeForCrazyAir.get("arrivalDate").asText()));
        }
        return Arrays.asList();
    }
}
