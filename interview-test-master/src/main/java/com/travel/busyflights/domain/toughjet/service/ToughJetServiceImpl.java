package com.travel.busyflights.domain.toughjet.service;

import com.travel.busyflights.domain.toughjet.request.ToughJetRequest;
import com.travel.busyflights.domain.toughjet.response.ToughJetResponse;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ToughJetServiceImpl implements ToughJetInterface{

    private static ToughJetResponse toughJetResponse;
    static{
         toughJetResponse = populateDummyData();
    }

    @Override
    public ToughJetResponse findByToughJet(ToughJetRequest toughJetRequest) {
        return toughJetResponse;
    }

    private static ToughJetResponse populateDummyData() {
        return new ToughJetResponse("Airline",2500,150,30,"LHR","AMS","01-06-2023","01-07-2023");

    }
}
