package com.travel.busyflights.domain.crazyair.restcontroller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.travel.busyflights.domain.busyflights.request.BusyFlightsRequest;
import com.travel.busyflights.domain.busyflights.response.BusyFlightsResponse;
import com.travel.busyflights.domain.crazyair.request.CrazyAirRequest;
import com.travel.busyflights.domain.crazyair.response.CrazyAirResponse;
import com.travel.busyflights.domain.crazyair.service.CrazyAirInterface;
import junit.framework.TestCase;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class CrazyAirRestControllerTest extends TestCase {

    @MockBean
    CrazyAirInterface crazyAirInterface;
    WebApplicationContext webApplicationContext;
    @Value(value = "${local.server.port}")
    private int port;  // The port that Spring randomly assigned.
    @Autowired
    private RestTemplate restTemplate;
    protected MockMvc mvc;
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
    public void testFetchCrazyAirFlights() throws Exception {
        String uri = "/crazyairsapis/crazyairflights";
        CrazyAirRequest crazyAirRequest=new CrazyAirRequest();
        Mockito.when(crazyAirInterface.findByCrazyAir(crazyAirRequest)).thenReturn((List<CrazyAirResponse>) crazyAirRequest);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/crazyairsapis/crazyairflights").accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = mvc.perform(requestBuilder).andReturn();
        System.out.println(result.getResponse());
        String expected = "{\"airline\":\"\",\"supplier\":\"CrazyAir\",\"fare\":\"2500\"}";
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }
}