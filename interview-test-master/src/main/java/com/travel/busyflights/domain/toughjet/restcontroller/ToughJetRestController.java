package com.travel.busyflights.domain.toughjet.restcontroller;

import com.travel.busyflights.domain.toughjet.request.ToughJetRequest;
import com.travel.busyflights.domain.toughjet.response.ToughJetResponse;
import com.travel.busyflights.domain.toughjet.service.ToughJetInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.DateFormatter;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/toughjetapis")
public class ToughJetRestController {
    @Autowired
    ToughJetInterface toughJetInterface;

    public ToughJetRestController(ToughJetInterface toughJetInterface) {
        this.toughJetInterface = toughJetInterface;
    }

    @GetMapping("/toughjets/{from}/{to}")
    public ResponseEntity<ToughJetResponse> findbyToughJetFlight(@PathVariable("from") String from, @PathVariable("to") String to, @RequestParam  int numberOfAdults) {
        ToughJetRequest toughJetRequest=new ToughJetRequest(from,to,null,null,numberOfAdults);
        ToughJetResponse toughJetResponse = toughJetInterface.findByToughJet(toughJetRequest);
        if (toughJetResponse==null) {
            return new ResponseEntity<ToughJetResponse>(HttpStatus.NO_CONTENT);
            // I many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<ToughJetResponse>(toughJetResponse, HttpStatus.OK);
    }
}
