package com.travel.busyflights.domain.crazyair.service;

import com.travel.busyflights.domain.crazyair.request.CrazyAirRequest;
import com.travel.busyflights.domain.crazyair.response.CrazyAirResponse;
import com.travel.busyflights.domain.toughjet.response.ToughJetResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CrazyAirServiceImpl implements CrazyAirInterface{

    private static List<CrazyAirResponse> CrazyAirResponse;
    static{
        CrazyAirResponse= populateCrazyAirData();
    }
    @Override
    public List<CrazyAirResponse> findByCrazyAir(CrazyAirRequest crazyAirRequest) {
        return CrazyAirResponse;
    }

    private static List<CrazyAirResponse> populateCrazyAirData() {
        return Arrays.asList(new CrazyAirResponse("CrazyAirLine",2500,"E","LHR","AHR","01-05-2023","01-06-2023"));

    }
}
