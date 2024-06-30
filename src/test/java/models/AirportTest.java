package models;

import org.junit.Before;
import com.keyin.cli.api.models.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class AirportTest {

    private Airport airport;

    @Before
    public void setUp() {
        airport = new Airport();
    }

    @Test
    public void testAirportConstructor() {
        airport = new Airport(1L,"Los Angeles International Airport" ,"LAX", "Los Angeles", "California");
        assertEquals(1L, airport.getAirport_ID());
        assertEquals("LAX", airport.getCode());
        assertEquals("Los Angeles International Airport", airport.getName());
        assertEquals("Los Angeles", airport.getCity());
        assertEquals("California", airport.getProvince());
    }

    @Test
    public void testAirportGettersAndSetters() {
        airport.setAirport_ID(2L);
        airport.setCode("JFK");
        airport.setName("John F. Kennedy International Airport");
        airport.setCity("New York City");
        airport.setProvince("New York");

        assertEquals(2L, airport.getAirport_ID());
        assertEquals("JFK", airport.getCode());
        assertEquals("John F. Kennedy International Airport", airport.getName());
        assertEquals("New York City", airport.getCity());
        assertEquals("New York", airport.getProvince());
    }

    @Test
    public void testAirportToString() {
        airport = new Airport(3L, "Paris Charles de Gaulle Airport" ,"CDG", "Paris", "Île-de-France");
        String expectedToString = "Airport - ID: 3, Name: Paris Charles de Gaulle Airport, Code: CDG, City: Paris, Province: Île-de-France.";
        assertEquals(expectedToString, airport.toString());
    }

    @Test
    public void testAirportEquals() {
        Airport airport1 = new Airport(1L, "Los Angeles International Airport","LAX", "Los Angeles", "California");
        Airport airport2 = new Airport(1L, "Los Angeles International Airport","LAX", "Los Angeles", "California");
        Airport airport3 = new Airport(2L, "John F. Kennedy International Airport","JFK",  "New York City", "New York");

        // Test equality of identical objects
        assertTrue(airport1.equals(airport2));

        // Test inequality of different objects
        assertFalse(airport1.equals(airport3));
    }

}
