package com.travel.busyflights.domain.busyflights.restcontroller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.travel.busyflights.domain.busyflights.request.BusyFlightsRequest;
import com.travel.busyflights.domain.busyflights.response.BusyFlightsResponse;
import com.travel.busyflights.domain.busyflights.service.BusyFlightInterface;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
public class BusyFlightRestControllerTest extends TestCase {
    @MockBean
    BusyFlightInterface busyFlightInterface;
    @Value(value = "${local.server.port}")
    private int port;  // The port that Spring randomly assigned.
    @Autowired
    private RestTemplate restTemplate;
    protected MockMvc mvc;
    WebApplicationContext webApplicationContext;
    @Override
    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    protected String mapToJson(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
    }
    protected <T> T mapFromJson(String json, Class<T> clazz)
            throws JsonParseException, JsonMappingException, IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, clazz);
    }
    @Test
    public void testGetBusyFlights() throws Exception {
        // prepare data and mock's behaviour
        String uri = "/busyflightsapi/busyflights";
        BusyFlightsRequest busyFlightsRequest=new BusyFlightsRequest("LHR","AHM","2023-05-20","2023-06-20",4);
        Mockito.when(busyFlightInterface.findByBusyFlight(busyFlightsRequest)).thenReturn((List<BusyFlightsResponse>) busyFlightsRequest);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/busyflightsapi/busyflights").accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = mvc.perform(requestBuilder).andReturn();
        System.out.println(result.getResponse());
        String expected = "{\"airline\":\"\",\"supplier\":\"CrazyAir\",\"fare\":\"2500\"}";
        JSONAssert.assertEquals(expected, result.getResponse()
                .getContentAsString(), false);
    }

}