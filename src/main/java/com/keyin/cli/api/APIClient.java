package com.keyin.cli.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keyin.cli.api.models.Flight;
import com.keyin.cli.api.models.Passenger;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class APIClient {
    private static final String BASE_URL = "http://localhost:8080/api"; // Replace with your actual server URL

    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    public APIClient() {
        this.httpClient = HttpClients.createDefault();
        this.objectMapper = new ObjectMapper();
    }

    public List<Flight> getAllFlights() throws IOException {
        HttpGet request = new HttpGet(BASE_URL + "/flights");
        return executeRequest(request, Flight[].class);
    }

    public List<Passenger> getAllPassengers() throws IOException {
        HttpGet request = new HttpGet(BASE_URL + "/passengers");
        return executeRequest(request, Passenger[].class);
    }

    public String bookFlight(long flightId, long passengerId, String seatClass) throws IOException {
        StringEntity requestEntity = new StringEntity(
                String.format("{\"flightId\": %d, \"passengerId\": %d, \"seatClass\": \"%s\"}", flightId, passengerId, seatClass));
        HttpPost request = new HttpPost(BASE_URL + "/bookings");
        request.setEntity(requestEntity);
        HttpResponse response = httpClient.execute(request);
        return EntityUtils.toString(response.getEntity());
    }

    private <T> List<T> executeRequest(HttpUriRequest request, Class<T[]> responseClass) throws IOException {
        HttpResponse response = httpClient.execute(request);
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            String json = EntityUtils.toString(entity);
            return Arrays.asList(objectMapper.readValue(json, responseClass));
        }
        return null;
    }
}
