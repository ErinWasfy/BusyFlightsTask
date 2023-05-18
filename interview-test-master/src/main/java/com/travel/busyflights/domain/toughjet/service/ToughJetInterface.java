package com.travel.busyflights.domain.toughjet.service;

import com.travel.busyflights.domain.toughjet.request.ToughJetRequest;
import com.travel.busyflights.domain.toughjet.response.ToughJetResponse;

import java.util.List;

public interface ToughJetInterface {
    ToughJetResponse findByToughJet(ToughJetRequest toughJetRequest);
}
