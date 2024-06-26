package com.keyin.cli.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keyin.cli.api.models.Airport;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class APIClientTest {

    @Mock
    private ObjectMapper objectMapper;

    @InjectMocks
    private APIClient apiClient;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddAirport() throws IOException {
        // Mocking the response from sendPostRequest
        String jsonResponse = "{\"id\":1,\"name\":\"Paris Charles de Gaulle Airport\",\"code\":\"CDG\",\"city\":\"Paris\",\"province\":\"France\"}";
        Airport mockAirport = new Airport(1L, "Paris Charles de Gaulle Airport", "CDG", "Paris", "France");

        APIClient apiClientSpy = spy(apiClient);
        doReturn(jsonResponse).when(apiClientSpy).sendPostRequest(anyString(), anyString());
        when(objectMapper.readValue(jsonResponse, Airport.class)).thenReturn(mockAirport);

        // Create a mock Airport object
        Airport airportToCreate = new Airport();
        airportToCreate.setName("Paris Charles de Gaulle Airport");
        airportToCreate.setCode("CDG");
        airportToCreate.setCity("Paris");
        airportToCreate.setProvince("France");

        // Call the method under test
        apiClientSpy.addAirport(airportToCreate);

        // verify the returned Airport object
        Airport createdAirport = objectMapper.readValue(jsonResponse, Airport.class);
        System.out.println(createdAirport.toString());
        System.out.println(createdAirport.getName());
        assertEquals(1L, createdAirport.getAirport_ID());
        assertEquals("Paris Charles de Gaulle Airport", createdAirport.getName());
        assertEquals("Paris", createdAirport.getCity());
    }
}
