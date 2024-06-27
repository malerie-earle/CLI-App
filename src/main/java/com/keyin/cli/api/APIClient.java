package com.keyin.cli.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keyin.cli.api.models.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.io.IOException;

public class APIClient {
    private static final String BASE_URL = "http://your.api.endpoint";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    private String sendGetRequest(String endpoint) throws IOException {
        URL url = new URL(BASE_URL + endpoint);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return response.toString();
        } else {
            throw new IOException("GET request failed: " + responseCode);
        }
    }

    private String sendPostRequest(String endpoint, String jsonInputString) throws IOException {
        URL url = new URL(BASE_URL + endpoint);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json; utf-8");
        connection.setRequestProperty("Accept", "application/json");
        connection.setDoOutput(true);

        try(OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        int responseCode = connection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return response.toString();
        } else {
            throw new IOException("POST request failed: " + responseCode);
        }
    }

    private String sendPutRequest(String endpoint, String jsonInputString) throws IOException {
        URL url = new URL(BASE_URL + endpoint);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("PUT");
        connection.setRequestProperty("Content-Type", "application/json; utf-8");
        connection.setRequestProperty("Accept", "application/json");
        connection.setDoOutput(true);

        try(OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        int responseCode = connection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return response.toString();
        } else {
            throw new IOException("PUT request failed: " + responseCode);
        }
    }

    private void sendDeleteRequest(String endpoint) throws IOException {
        URL url = new URL(BASE_URL + endpoint);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("DELETE");
        int responseCode = connection.getResponseCode();

        if (responseCode != HttpURLConnection.HTTP_OK) {
            throw new IOException("DELETE request failed: " + responseCode);
        }
    }

    public List<Airport> getAllAirports() throws IOException {
        String response = sendGetRequest("/airports");
        return Arrays.asList(objectMapper.readValue(response, Airport[].class));
    }

    public List<Aircraft> getAllAircrafts() throws IOException {
        String response = sendGetRequest("/aircrafts");
        return Arrays.asList(objectMapper.readValue(response, Aircraft[].class));
    }

    public List<Flight> getAllFlights() throws IOException {
        String response = sendGetRequest("/flights");
        return Arrays.asList(objectMapper.readValue(response, Flight[].class));
    }

    public List<Booking> getAllBookings() throws IOException {
        String response = sendGetRequest("/bookings");
        return Arrays.asList(objectMapper.readValue(response, Booking[].class));
    }

    public List<Passenger> getAllPassengers() throws IOException {
        String response = sendGetRequest("/passengers");
        return Arrays.asList(objectMapper.readValue(response, Passenger[].class));
    }

    public List<SeatingChart> getAllSeatingCharts() throws IOException {
        String response = sendGetRequest("/seating-charts");
        return Arrays.asList(objectMapper.readValue(response, SeatingChart[].class));
    }

    public String bookFlight(long flightId, long passengerId) throws IOException {
        BookingRequest bookingRequest = new BookingRequest(flightId, passengerId);
        String jsonInputString = objectMapper.writeValueAsString(bookingRequest);
        return sendPostRequest("/book-flight", jsonInputString);
    }

    // Add these methods to support flight operations
    public List<Flight> searchFlights(String searchCriteria) throws IOException {
        String response = sendGetRequest("/flights/search?criteria=" + searchCriteria);
        return Arrays.asList(objectMapper.readValue(response, Flight[].class));
    }

    public Flight addFlight(String flightDetails) throws IOException {
        String jsonInputString = flightDetails; // Assuming flightDetails is already a JSON string
        String response = sendPostRequest("/flights", jsonInputString);
        return objectMapper.readValue(response, Flight.class);
    }

    public Flight updateFlight(long flightId, String updatedDetails) throws IOException {
        String jsonInputString = updatedDetails; // Assuming updatedDetails is already a JSON string
        String response = sendPutRequest("/flights/" + flightId, jsonInputString);
        return objectMapper.readValue(response, Flight.class);
    }

    public void deleteFlight(long flightId) throws IOException {
        sendDeleteRequest("/flights/" + flightId);
    }

    // Add this method to support adding an airport
    public void addAirport(Airport airport) throws IOException {
        String jsonInputString = objectMapper.writeValueAsString(airport);
        sendPostRequest("/airports", jsonInputString);
    }
}
