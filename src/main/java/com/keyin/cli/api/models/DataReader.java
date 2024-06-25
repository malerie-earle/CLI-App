package com.keyin.rest.dataReader;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.keyin.rest.aircraft.Aircraft;
import com.keyin.rest.airport.Airport;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class DataReader {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Loads a list of Aircraft objects from a JSON file.
     *
     * @param jsonFilePath The path to the JSON file containing the aircraft data.
     * @return A list of Aircraft objects.
     * @throws IOException If there is an issue reading the file or parsing the JSON.
     */
    public static List<Aircraft> loadAircraftsFromJson(String jsonFilePath) throws IOException {
        try {
            return objectMapper.readValue(new File(jsonFilePath), new TypeReference<List<Aircraft>>() {});
        } catch (IOException e) {
            System.err.println("Error reading Aircraft JSON file: " + e.getMessage());
            throw e;
        }
    }

    /**
     * Loads a list of Airport objects from a JSON file.
     *
     * @param jsonFilePath The path to the JSON file containing the airport data.
     * @return A list of Airport objects.
     * @throws IOException If there is an issue reading the file or parsing the JSON.
     */
    public static List<Airport> loadAirportsFromJson(String jsonFilePath) throws IOException {
        try {
            return objectMapper.readValue(new File(jsonFilePath), new TypeReference<List<Airport>>() {});
        } catch (IOException e) {
            System.err.println("Error reading Airport JSON file: " + e.getMessage());
            throw e;
        }
    }

}