package com.keyin.cli.api.models;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.keyin.cli.api.models.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class DataReader {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static List<Aircraft> loadAircraftsFromJson(String jsonFilePath) throws IOException {
        try {
            return objectMapper.readValue(new File(jsonFilePath), new TypeReference<List<Aircraft>>() {});
        } catch (IOException e) {
            System.err.println("Error reading Aircraft JSON file: " + e.getMessage());
            throw e;
        }
    }

    public static List<Airport> loadAirportsFromJson(String jsonFilePath) throws IOException {
        try {
            return objectMapper.readValue(new File(jsonFilePath), new TypeReference<List<Airport>>() {});
        } catch (IOException e) {
            System.err.println("Error reading Airport JSON file: " + e.getMessage());
            throw e;
        }
    }
}
