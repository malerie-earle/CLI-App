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

    // Airport API Calls
    public List<Airport> getAllAirports() throws IOException {
        String response = sendGetRequest("/airports");
        return Arrays.asList(objectMapper.readValue(response, Airport[].class));
    }

    public Airport getAirportbyID(int id) throws IOException{
        String response = sendGetRequest("/airport/"+id);
        return objectMapper.readValue(response,Airport.class);
    }

    public void addAirport(Airport airport) throws IOException {
        String jsonInputString = objectMapper.writeValueAsString(airport);
        sendPostRequest("/airport", jsonInputString);
    }

    public void updateAirport(long airport_ID, Airport updatedAirport) throws IOException {
        String jsonInputString = objectMapper.writeValueAsString(updatedAirport);
        sendPutRequest("/airport/airport_ID", jsonInputString);
    }

    public void deleteAirport(long airport_ID) throws IOException {
        sendDeleteRequest("/airport/airport_ID");
    }

    public List<Airport> searchAirportByID(long airport_ID) throws IOException {
        String response = sendGetRequest("/airport/airport_ID");
        return Arrays.asList(objectMapper.readValue(response, Airport[].class));
    }

    public List<Airport> searchAirportByName(String name) throws IOException {
        String response = sendGetRequest("/airport/name");
        return Arrays.asList(objectMapper.readValue(response, Airport[].class));
    }

    public List<Airport> searchAirportByProvince(String province) throws IOException {
        String response = sendGetRequest("/airport/province");
        return Arrays.asList(objectMapper.readValue(response, Airport[].class));
    }

    // Aircraft API Calls
    public List<Aircraft> getAllAircrafts() throws IOException {
        String response = sendGetRequest("/aircrafts");
        return Arrays.asList(objectMapper.readValue(response, Aircraft[].class));
    }

    public void addAircraft(Aircraft aircraft) throws IOException {
        String jsonInputString = objectMapper.writeValueAsString(aircraft);
        sendPostRequest("/aircraft", jsonInputString);
    }

    public void updateAircraft(long aircraft_ID, Aircraft updatedAircraft) throws IOException {
        String jsonInputString = objectMapper.writeValueAsString(updatedAircraft);
        sendPutRequest("/aircraft/aircraft_ID", jsonInputString);
    }

    public void deleteAircraft(long aircraft_ID) throws IOException {
        sendDeleteRequest("/aircraft/aircraft_ID");
    }

    public List<Aircraft> searchAircraftByID(long aircraft_ID) throws IOException {
        String response = sendGetRequest("/aircraft/aircraft_ID");
        return Arrays.asList(objectMapper.readValue(response, Aircraft[].class));
    }

    public List<Aircraft> searchAircraftByAirline(String airline) throws IOException {
        String response = sendGetRequest("/aircraft/airline");
        return Arrays.asList(objectMapper.readValue(response, Aircraft[].class));
    }

    public List<Aircraft> searchAircraftByModel(String model) throws IOException {
        String response = sendGetRequest("/aircraft/model");
        return Arrays.asList(objectMapper.readValue(response, Aircraft[].class));
    }

    // Flight API Calls
    public List<Flight> getAllFlights() throws IOException {
        String response = sendGetRequest("/flights");
        return Arrays.asList(objectMapper.readValue(response, Flight[].class));
    }

    public Flight addFlight(Flight flight) throws IOException {
        String jsonInputString = objectMapper.writeValueAsString(flight);
        String response = sendPostRequest("/flight", jsonInputString);
        return objectMapper.readValue(response, Flight.class);
    }

    public Flight updateFlight(long flightId, String updatedFlight) throws IOException {
        String jsonInputString = objectMapper.writeValueAsString(updatedFlight);
        String response = sendPutRequest("/flight/flightId", jsonInputString);
        return objectMapper.readValue(response, Flight.class);
    }

    public void deleteFlight(long flightId) throws IOException {
        sendDeleteRequest("/flight/flightId");
    }

    public List<Flight> searchFlightByID(long flight_ID) throws IOException {
        String response = sendGetRequest("/flight/flight_ID");
        return Arrays.asList(objectMapper.readValue(response, Flight[].class));
    }

    public List<Flight> searchFlightByOrigin(String origin) throws IOException {
        String response = sendGetRequest("/flight/origin/" + origin);
        return Arrays.asList(objectMapper.readValue(response, Flight[].class));
    }

    public List<Flight> searchFlightByDestination(String destination) throws IOException {
        String response = sendGetRequest("/flight/destination/" + destination);
        return Arrays.asList(objectMapper.readValue(response, Flight[].class));
    }

    public List<Flight> searchFlightByStatus(String status) throws IOException {
        String response = sendGetRequest("/flight/status/" + status);
        return Arrays.asList(objectMapper.readValue(response, Flight[].class));
    }

    public List<Flight> searchFlightByAircraft(long aircraft_ID) throws IOException {
        String response = sendGetRequest("/flight/aircraft/" + aircraft_ID);
        return Arrays.asList(objectMapper.readValue(response, Flight[].class));
    }

    public List<Flight> searchFlightByAirport(long airport_ID) throws IOException {
        String response = sendGetRequest("/flight/airport/" + airport_ID);
        return Arrays.asList(objectMapper.readValue(response, Flight[].class));
    }

    // Booking API Calls
    // check urls as different than others
    public List<Booking> getAllBookings() throws IOException {
        String response = sendGetRequest("/bookings");
        return Arrays.asList(objectMapper.readValue(response, Booking[].class));
    }

    public Booking addBooking(Booking booking) throws IOException {
        String jsonInputString = objectMapper.writeValueAsString(booking);
        String response = sendPostRequest("/booking", jsonInputString);
        return objectMapper.readValue(response, Booking.class);
    }

    public String bookFlight(long flightId, long passengerId, int seatRow, int seatColumn) throws IOException {
        Booking booking = new Booking(0, flightId, passengerId, seatRow, seatColumn);
        String jsonInputString = objectMapper.writeValueAsString(booking);
        return sendPostRequest("/flight/book", jsonInputString);
    }

    public Booking updateBooking(long booking_ID, Booking updatedBooking) throws IOException {
        String jsonInputString = objectMapper.writeValueAsString(updatedBooking);
        String response = sendPutRequest("/flight/book/update/booking_ID", jsonInputString);
        return objectMapper.readValue(response, Booking.class);
    }

    public void deleteBooking(long booking_ID) throws IOException {
        sendDeleteRequest("/flight/book/delete/booking_ID");
    }

    public List<Booking> searchBookingByID(long booking_ID) throws IOException {
        String response = sendGetRequest("/booking/booking_ID");
        return Arrays.asList(objectMapper.readValue(response, Booking[].class));
    }

    public List<Booking> searchBookingByFlight(long flight_ID) throws IOException {
        String response = sendGetRequest("/booking/flight/flight_ID");
        return Arrays.asList(objectMapper.readValue(response, Booking[].class));
    }

    public List<Booking> searchBookingByPassenger(long passenger_ID) throws IOException {
        String response = sendGetRequest("/booking/passenger/passenger_ID");
        return Arrays.asList(objectMapper.readValue(response, Booking[].class));
    }


    // Passenger API Calls
    public List<Passenger> getAllPassengers() throws IOException {
        String response = sendGetRequest("/passengers");
        return Arrays.asList(objectMapper.readValue(response, Passenger[].class));
    }

    public Passenger addPassenger(Passenger passenger) throws IOException {
        String jsonInputString = objectMapper.writeValueAsString(passenger);
        String response = sendPostRequest("/passenger", jsonInputString);
        return objectMapper.readValue(response, Passenger.class);
    }


    public Booking bookFlight(long flightId, long passengerId, int row, int column) throws IOException {
        //BookingRequest bookingRequest = new BookingRequest(flightId, passengerId);
        Booking newBooking = new Booking(0, flightId, passengerId, row, column);
        String jsonInputString = objectMapper.writeValueAsString(newBooking);
        String response = sendPostRequest("/flight/book", jsonInputString);
        return objectMapper.readValue(response, Booking.class);

    public Passenger updatePassenger(long passenger_ID, Passenger updatedPassenger) throws IOException {
        String jsonInputString = objectMapper.writeValueAsString(updatedPassenger);
        String response = sendPutRequest("/passenger/passenger_ID", jsonInputString);
        return objectMapper.readValue(response, Passenger.class);
    }

    public void deletePassenger(long passenger_ID) throws IOException {
        sendDeleteRequest("/passenger/passenger_ID");
    }

    public List<Passenger> searchPassengerByID(long passenger_ID) throws IOException {
        String response = sendGetRequest("/passenger/passenger_ID");
        return Arrays.asList(objectMapper.readValue(response, Passenger[].class));
    }

    public List<Passenger> searchPassengerByName(String name) throws IOException {
//        String name = first_name + " " + last_name;
        String response = sendGetRequest("/passenger/name");
        return Arrays.asList(objectMapper.readValue(response, Passenger[].class));
    }

    public List<SeatingChart> getAllSeatingCharts() throws IOException {
        String response = sendGetRequest("/seating-charts");
        return Arrays.asList(objectMapper.readValue(response, SeatingChart[].class));
    }

}
