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
    private static final String BASE_URL = "http://localhost:8080";
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

    public List<Airport> getAllAirports() throws IOException {
        String response = sendGetRequest("/airports");
        return Arrays.asList(objectMapper.readValue(response, Airport[].class));
    }

    public Airport getAirportbyID(int id) throws IOException{
        String response = sendGetRequest("/airport/"+id);
        return objectMapper.readValue(response,Airport.class);
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

    public Booking bookFlight(long flightId, long passengerId, int row, int column) throws IOException {
        //BookingRequest bookingRequest = new BookingRequest(flightId, passengerId);
        Booking newBooking = new Booking(0, flightId, passengerId, row, column);
        String jsonInputString = objectMapper.writeValueAsString(newBooking);
        String response = sendPostRequest("/flight/book", jsonInputString);
        return objectMapper.readValue(response, Booking.class);
    }

    // You need to create a BookingRequest class to handle the booking data
    private static class BookingRequest {
        private long flightId;
        private long passengerId;

        public BookingRequest(long flightId, long passengerId) {
            this.flightId = flightId;
            this.passengerId = passengerId;
        }

        public long getFlightId() {
            return flightId;
        }

        public long getPassengerId() {
            return passengerId;
        }
    }
}
