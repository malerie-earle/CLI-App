package models;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import com.keyin.cli.api.models.Aircraft;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertNotNull;

public class AircraftTest {

    @Test
    public void testEmptySeatingChart() {
        Aircraft aircraft = new Aircraft(1, "Boeing 737", "Airline X", 150, 30, 6, 1);
        List<String> chart = aircraft.emptySeatingChart();

        assertNotNull(chart);
        // Add more specific assertions if needed for the seating chart structure
    }

    @Test
    public void testAircraftToString() {
        Aircraft aircraft = new Aircraft(1, "Boeing 737", "Airline X", 150, 30, 6, 1);
        String expectedToString = "Aircraft - ID: 1, Model: Boeing 737, Airline: Airline X, Capacity: 150, Rows: 30, Columns: 6, Number of Aisles: 1.";

        String actualToString = aircraft.toString();

        assertNotNull(actualToString);
        // Example assertion for toString method
        assert(actualToString.contains("Aircraft - ID: 1"));
    }
}
