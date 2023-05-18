package com.travel.busyflights.domain.crazyair.service;

import com.travel.busyflights.domain.crazyair.request.CrazyAirRequest;
import com.travel.busyflights.domain.crazyair.response.CrazyAirResponse;

import java.util.List;

public interface CrazyAirInterface {

    List<CrazyAirResponse> findByCrazyAir(CrazyAirRequest crazyAirRequest);
}
